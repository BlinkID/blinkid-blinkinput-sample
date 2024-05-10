package com.microblink.blinkid;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.microblink.blinkid.entities.recognizers.Recognizer;
import com.microblink.blinkid.entities.recognizers.RecognizerBundle;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.BlinkIdSingleSideRecognizer;
import com.microblink.blinkid.entities.recognizers.framegrabber.FrameCallback;
import com.microblink.blinkid.entities.recognizers.framegrabber.FrameGrabberRecognizer;
import com.microblink.blinkid.hardware.SuccessCallback;
import com.microblink.blinkid.hardware.orientation.Orientation;
import com.microblink.blinkid.image.Image;
import com.microblink.blinkid.metadata.MetadataCallbacks;
import com.microblink.blinkid.metadata.detection.FailedDetectionCallback;
import com.microblink.blinkid.metadata.detection.quad.DisplayableQuadDetection;
import com.microblink.blinkid.metadata.detection.quad.QuadDetectionCallback;
import com.microblink.blinkid.recognition.RecognitionSuccessType;
import com.microblink.blinkid.util.CameraPermissionManager;
import com.microblink.blinkid.util.Log;
import com.microblink.blinkid.view.CameraAspectMode;
import com.microblink.blinkid.view.CameraEventsListener;
import com.microblink.blinkid.view.OnSizeChangedListener;
import com.microblink.blinkid.view.OrientationAllowedListener;
import com.microblink.blinkid.view.recognition.DetectionStatus;
import com.microblink.blinkid.view.recognition.RecognizerRunnerView;
import com.microblink.blinkid.view.recognition.ScanResultListener;
import com.microblink.blinkid.view.viewfinder.quadview.QuadViewManager;
import com.microblink.blinkid.view.viewfinder.quadview.QuadViewManagerFactory;
import com.microblink.blinkid.view.viewfinder.quadview.QuadViewPreset;
import com.microblink.blinkinput.directApi.DirectApiErrorListener;
import com.microblink.blinkinput.directApi.RecognizerRunner;
import com.microblink.blinkinput.entities.detectors.quad.document.DocumentDetector;
import com.microblink.blinkinput.entities.detectors.quad.document.DocumentSpecification;
import com.microblink.blinkinput.entities.detectors.quad.document.DocumentSpecificationPreset;
import com.microblink.blinkinput.entities.processors.imageReturn.ImageReturnProcessor;
import com.microblink.blinkinput.entities.recognizers.blinkbarcode.barcode.BarcodeRecognizer;
import com.microblink.blinkinput.entities.recognizers.detector.DetectorRecognizer;
import com.microblink.blinkinput.entities.recognizers.templating.ProcessorGroup;
import com.microblink.blinkinput.entities.recognizers.templating.TemplatingClass;
import com.microblink.blinkinput.entities.recognizers.templating.dewarpPolicies.DPIBasedDewarpPolicy;
import com.microblink.blinkinput.geometry.Rectangle;
import com.microblink.blinkinput.image.ImageBuilder;
import com.microblink.blinkinput.image.InputImage;

import java.util.Timer;
import java.util.TimerTask;

public class MyScanActivity extends Activity implements ScanResultListener, CameraEventsListener, OnSizeChangedListener {

    public static final String TAG = "MyScanActivity";

    private Handler mHandler = new Handler();

    private RecognizerBundle mBlinkIdRecognizerBundle;

    private com.microblink.blinkinput.entities.recognizers.RecognizerBundle mBlinkInputRecognizerBundle;

    /**
     * This is a RecognizerView - it contains camera view and can contain camera overlays
     */
    RecognizerRunnerView mBlinkIdRecognizerView;

    /**
     * Direct API for BlinkInput.
     */
    RecognizerRunner mBlinkInputRecognizerRunner;
    /**
     * CameraPermissionManager is provided helper class that can be used to obtain the permission to use camera.
     * It is used on Android 6.0 (API level 23) or newer.
     */
    private CameraPermissionManager mCameraPermissionManager;
    /**
     * This is a back button
     */
    private ImageButton mBackButton = null;
    /**
     * This is a torch control button
     */
    private ImageButton mTorchButton = null;
    /**
     * Is torch enabled?
     */
    private boolean mTorchEnabled = false;
    /**
     * This is a text field that contains status messages
     */
    private TextView mStatusTextView = null;
    /**
     * This is BlinkID's built-in helper for built-in view that draws detection location
     */
    QuadViewManager mQvManager = null;
    /**
     * MediaPlayer will be used for beep sound
     */
    private MediaPlayer mMediaPlayer = null;

    private Timer mCustomTimer = null;

    // just a simple bool to indicate which result to pack into the result intent
    private boolean mUsingBlinkInput = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_scan);
        mBlinkIdRecognizerView = findViewById(R.id.recognizerView);

        mBlinkIdRecognizerBundle = new RecognizerBundle(createRecognizers());
        mBlinkIdRecognizerBundle.setNumMsBeforeTimeout(5000); // 5 seconds timeout
        mBlinkIdRecognizerView.setRecognizerBundle(mBlinkIdRecognizerBundle);

        // scan result listener will be notified when scan result gets available
        mBlinkIdRecognizerView.setScanResultListener(this);
        // camera events listener receives events such as when camera preview has started
        // or there was an error while starting the camera
        mBlinkIdRecognizerView.setCameraEventsListener(this);
        // orientation allowed listener is asked if orientation is allowed when device orientation
        // changes - if orientation is allowed, rotatable views will be rotated to that orientation
        mBlinkIdRecognizerView.setOrientationAllowedListener(new OrientationAllowedListener() {
            @Override
            public boolean isOrientationAllowed(Orientation orientation) {
                // allow all orientations
                return true;
            }
        });
        // on size changed listener is notified whenever the size of the view is changed (for example
        // when transforming the view from portrait to landscape or vice versa)
        mBlinkIdRecognizerView.setOnSizeChangedListener(this);

        setupMetadataCallbacks();

        // set initial orientation
        mBlinkIdRecognizerView.setInitialOrientation(Orientation.ORIENTATION_PORTRAIT);

        // set camera aspect mode to FILL - this will use the entire surface
        // for camera preview, instead of letterboxing it
        mBlinkIdRecognizerView.setAspectMode(CameraAspectMode.ASPECT_FILL);

        // instantiate the camera permission manager
        mCameraPermissionManager = new CameraPermissionManager(this);
        // get the built in layout that should be displayed when camera permission is not given
        View v = mCameraPermissionManager.getAskPermissionOverlay();
        if (v != null) {
            // add it to the current layout that contains the recognizer view
            ViewGroup vg = findViewById(R.id.my_scan_root);
            vg.addView(v);
        }

        // create scanner (make sure scan settings and listeners were set prior calling create)
        mBlinkIdRecognizerView.create();

        // after scanner is created, you can add your views to it

        // Use provided factory method from QuadViewManagerFactory that can instantiate the
        // QuadViewManager based on several presets defined in QuadViewPreset enum. Details about
        // each of them can be found in javadoc. This method automatically adds the QuadView as a
        // child of RecognizerView.
        // Here we use preset which sets up quad view in the same style as used in built-in BlinkID DocumentScan activity.
        mQvManager = QuadViewManagerFactory.createQuadViewFromPreset(mBlinkIdRecognizerView, QuadViewPreset.DEFAULT_CORNERS_FROM_PHOTOPAY_ACTIVITY);

        // initialize buttons and status view
        View view = getLayoutInflater().inflate(R.layout.default_blinkid_viewfinder, null);

        mBackButton = view.findViewById(R.id.defaultBackButton);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });

        mTorchButton = view.findViewById(R.id.defaultTorchButton);
        mTorchButton.setVisibility(View.GONE);

        mStatusTextView = view.findViewById(R.id.defaultStatusTextView);
        mStatusTextView.setVisibility(View.INVISIBLE);

        // add buttons and status view as rotatable view to BlinkIdView (it will be rotated even if activity remains in portrait/landscape)
        // allowed orientations are controlled via OrientationAllowedListener
        mBlinkIdRecognizerView.addChildView(view, true);

        // immediately initialize BlinkInput DirectAPI in case it will be needed
        initializeBlinkInputDirectAPI();
    }

    private void setupMetadataCallbacks() {
        MetadataCallbacks metadataCallbacks = new MetadataCallbacks();
        // add callback for each metadata type you're interested in
        metadataCallbacks.setQuadDetectionCallback(new QuadDetectionCallback() {
            @Override
            public void onQuadDetection(@NonNull DisplayableQuadDetection displayableQuadDetection) {
                // begin quadrilateral animation to detected quadrilateral
                mQvManager.animateQuadToDetectionPosition(displayableQuadDetection);

                DetectionStatus detectionStatus = displayableQuadDetection.getDetectionStatus();

                // displays message about detection status to the user
                if (detectionStatus == DetectionStatus.SUCCESS) {
                    displayText(R.string.msg_processing);
                } else if (detectionStatus == DetectionStatus.FAILED) {
                    displayText(R.string.msg_align);
                } else if (detectionStatus == DetectionStatus.CAMERA_TOO_FAR) {
                    displayText(R.string.msg_camera_too_far);
                } else if (detectionStatus == DetectionStatus.DOCUMENT_PARTIALLY_VISIBLE) {
                    displayText(R.string.msg_partial_detected);
                }
            }
        });

        metadataCallbacks.setFailedDetectionCallback(new FailedDetectionCallback() {
            @Override
            public void onDetectionFailed() {
                mQvManager.animateQuadToDefaultPosition();
            }
        });

        mBlinkIdRecognizerView.setMetadataCallbacks(metadataCallbacks);
    }

    private DisplayableQuadDetection convertDisplayableQuad(com.microblink.blinkinput.metadata.detection.quad.DisplayableQuadDetection dq) {
        int detectionStatus = dq.getDetectionStatus().ordinal();
        float[] transformMatrix = new float[9];
        dq.getTransformMatrix().getValues(transformMatrix);
        float[] displayLocation = new float[8];
        dq.getDisplayLocation().toFloatArray(displayLocation);

        return new DisplayableQuadDetection(detectionStatus, transformMatrix, displayLocation);
    }

    private void setupBlinkInputMetadataCallbacks() {
        com.microblink.blinkinput.metadata.MetadataCallbacks metadataCallbacks = new com.microblink.blinkinput.metadata.MetadataCallbacks();
        // add callback for each metadata type you're interested in
        metadataCallbacks.setQuadDetectionCallback(new com.microblink.blinkinput.metadata.detection.quad.QuadDetectionCallback() {
            @Override
            public void onQuadDetection(@NonNull com.microblink.blinkinput.metadata.detection.quad.DisplayableQuadDetection displayableQuadDetection) {
                // begin quadrilateral animation to detected quadrilateral
                mQvManager.animateQuadToDetectionPosition(convertDisplayableQuad(displayableQuadDetection));
            }
        });

        metadataCallbacks.setFailedDetectionCallback(new com.microblink.blinkinput.metadata.detection.FailedDetectionCallback() {
            @Override
            public void onDetectionFailed() {
                mQvManager.animateQuadToDefaultPosition();
            }
        });

        mBlinkInputRecognizerRunner.setMetadataCallbacks(metadataCallbacks);
    }

    private Recognizer[] createRecognizers() {
        BlinkIdSingleSideRecognizer genericRecognizer = new BlinkIdSingleSideRecognizer();

        return new Recognizer[]{genericRecognizer};
    }

    private Recognizer[] createFallbackRecognizers() {
        FrameGrabberRecognizer frameGrabberRecognizer = new FrameGrabberRecognizer(new FrameCallback() {
            @Override
            public void onFrameAvailable(@Nullable Image image, boolean focused, double quality) {
                if (image != null && mBlinkInputRecognizerRunner != null && mBlinkInputRecognizerRunner.getCurrentState() == RecognizerRunner.State.READY) {
                    // need to clone the image in order to avoid accessing released memory
                    Image clone = image.clone();
                    InputImage inputImage = ImageBuilder.buildInputImageFromByteBuffer(
                            clone.getBuffer(),
                            clone.getRawWidth(),
                            clone.getRawHeight(),
                            clone.getRowStride(),
                            com.microblink.blinkinput.hardware.orientation.Orientation.values()[clone.getImageOrientation().ordinal()],
                            clone
                    );
                    mBlinkInputRecognizerRunner.recognizeVideoImage(
                        inputImage,
                        new com.microblink.blinkinput.view.recognition.ScanResultListener() {
                            @Override
                            public void onScanningDone(@NonNull com.microblink.blinkinput.recognition.RecognitionSuccessType recognitionSuccessType) {
                                MyScanActivity.this.onScanningDone(RecognitionSuccessType.values()[recognitionSuccessType.ordinal()]);
                            }

                            @Override
                            public void onUnrecoverableError(@NonNull Throwable throwable) {
                                MyScanActivity.this.onUnrecoverableError(throwable);
                            }
                        }
                    );
                }
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(@NonNull Parcel dest, int flags) {

            }
        });

        return new Recognizer[]{frameGrabberRecognizer};
    }

    private void initializeBlinkInputDirectAPI() {
        BarcodeRecognizer barcodeRecognizer = new BarcodeRecognizer();
        barcodeRecognizer.setScanPdf417(true);
        barcodeRecognizer.setScanQrCode(true);
        barcodeRecognizer.setScanUncertain(true);

        // detector recognizer
        DocumentDetector idCardDetector = buildDocumentDetectorFromPreset(DocumentSpecificationPreset.DOCUMENT_SPECIFICATION_PRESET_ID1_CARD);
        DetectorRecognizer detectorRecognizer = new DetectorRecognizer(idCardDetector);

        // processor that will simply save obtained image
        ImageReturnProcessor imageReturnProcessor = new ImageReturnProcessor();
        // processor group that will be executed on the detected document location
        ProcessorGroup processorGroup = new ProcessorGroup(
                // process entire detected location
                new Rectangle(0.f, 0.f, 1.f, 1.f),
                // dewarp height will be calculated based on actual physical size of detected
                // location and requested DPI
                new DPIBasedDewarpPolicy(200),
                // only image is needed
                imageReturnProcessor
        );

        // Templating class is used to define how specific document type should be processed.
        // Only image should be returned, which means that classification of the document
        // based on the processed data is not needed, so only one document class is defined.
        TemplatingClass documentClass = new TemplatingClass();
        // prepared processor group is added to classification processor groups because
        // they are executed before classification
        documentClass.setClassificationProcessorGroups(processorGroup);
        detectorRecognizer.setTemplatingClasses(documentClass);

        mBlinkInputRecognizerBundle = new com.microblink.blinkinput.entities.recognizers.RecognizerBundle(barcodeRecognizer, detectorRecognizer);

        mBlinkInputRecognizerRunner = RecognizerRunner.getSingletonInstance();
        mBlinkInputRecognizerRunner.initialize(this, mBlinkInputRecognizerBundle, new DirectApiErrorListener() {
            @Override
            public void onRecognizerError(@NonNull Throwable throwable) {
                com.microblink.blinkid.util.Log.e(this, throwable, "Error in BlinkInput initialization!");
                handleError();
            }
        });
        setupBlinkInputMetadataCallbacks();
    }

    private DocumentDetector buildDocumentDetectorFromPreset(DocumentSpecificationPreset documentSpecPreset) {
        // create document specification from preset
        DocumentSpecification documentSpec = DocumentSpecification.createFromPreset(documentSpecPreset);
        // prepare document detector with defined document specification
        DocumentDetector documentDetector = new DocumentDetector(documentSpec);
        // set minimum number of stable detections to return detector result
        documentDetector.setNumStableDetectionsThreshold(3);
        return documentDetector;
    }

    @Override
    protected void onResume() {
        super.onResume();
        // all activity lifecycle events must be passed on to RecognizerView
        if (mBlinkIdRecognizerView != null) {
            mBlinkIdRecognizerView.resume();
        }
        mMediaPlayer = MediaPlayer.create(this, R.raw.beep);

        // start the timer
        if (mCustomTimer == null) {
            mCustomTimer = new Timer();
            mCustomTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (mBlinkIdRecognizerView != null) {
                        mBlinkIdRecognizerView.pauseScanning();
                        handleTimeout();
                    }
                }
            }, 5000);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        // all activity lifecycle events must be passed on to RecognizerView
        if (mBlinkIdRecognizerView != null) {
            mBlinkIdRecognizerView.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // all activity lifecycle events must be passed on to RecognizerView
        if (mBlinkIdRecognizerView != null) {
            mBlinkIdRecognizerView.pause();
        }
        if (mMediaPlayer != null) {
            mMediaPlayer = null;
        }
        if (mCustomTimer != null) {
            mCustomTimer.cancel();
            mCustomTimer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        // all activity lifecycle events must be passed on to RecognizerView
        if (mBlinkIdRecognizerView != null) {
            mBlinkIdRecognizerView.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // all activity lifecycle events must be passed on to RecognizerView
        if (mBlinkIdRecognizerView != null) {
            mBlinkIdRecognizerView.destroy();
        }
        if (mBlinkInputRecognizerRunner != null) {
            mBlinkInputRecognizerRunner.terminate();
        }
    }

    /**
     * Plays beep sound.
     */
    private void soundNotification() {
        if (mMediaPlayer != null) {
            Log.d(TAG, "Playing beep sound");
            mMediaPlayer.start();
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mp) {
                    if (mMediaPlayer == null) {
                        mp.release();
                    }
                }
            });
        }
    }

    @Override
    public void onScanningDone(@NonNull RecognitionSuccessType recognitionSuccessType) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                soundNotification();
            }
        });

        mBlinkIdRecognizerView.pauseScanning();

        if (recognitionSuccessType == RecognitionSuccessType.SUCCESSFUL) {
            Intent resultIntent = new Intent();
            if (mUsingBlinkInput) {
                // save BlinkInput results
                mBlinkInputRecognizerBundle.saveToIntent(resultIntent);
            } else {
                // save BlinkID results
                mBlinkIdRecognizerBundle.saveToIntent(resultIntent);
            }
            setResult(RESULT_OK, resultIntent);
            finish();
        } else {
            handleTimeout();
        }
    }

    private void handleTimeout() {
        displayText(R.string.msg_timeout);
        // timeout reached, reconfigure to using barcode + detector recognizer
        // and then resume
        mBlinkIdRecognizerBundle = new RecognizerBundle(createFallbackRecognizers());
        mBlinkIdRecognizerView.reconfigureRecognizers(mBlinkIdRecognizerBundle);
        mBlinkIdRecognizerView.resumeScanning(true);
        mUsingBlinkInput = true;
    }

    @Override
    public void onUnrecoverableError(@NonNull Throwable throwable) {
        Toast.makeText(MyScanActivity.this, throwable.toString(), Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onCameraPreviewStarted() {
        // this method is called just after camera preview has started
        enableTorchButtonIfPossible();
    }

    @Override
    public void onCameraPreviewStopped() {
        // this method is called just after camera preview has stopped
    }

    private void enableTorchButtonIfPossible() {
        if (!mBlinkIdRecognizerView.isCameraTorchSupported() || mTorchButton == null) {
            return;
        }

        mTorchButton.setVisibility(View.VISIBLE);
        mTorchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTorchBtnClick();
            }
        });
    }

    private void onTorchBtnClick() {
        mBlinkIdRecognizerView.setTorchState(!mTorchEnabled, new SuccessCallback() {
            @Override
            public void onOperationDone(final boolean success) {
                if (!success) {
                    return;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTorchEnabled = !mTorchEnabled;
                        if (mTorchEnabled) {
                            mTorchButton.setImageResource(R.drawable.mb_ic_flash_on);
                        } else {
                            mTorchButton.setImageResource(R.drawable.mb_ic_flash_off);
                        }
                    }
                });
            }
        });
    }

    @Override
    public void onError(Throwable ex) {
        // This method will be called when opening of camera resulted in exception or
        // recognition process encountered an error.
        // The error details will be given in ex parameter.
        com.microblink.blinkid.util.Log.e(this, ex, "Error");
        handleError();
    }

    @SuppressWarnings("deprecation")
    private void handleError() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(getString(R.string.error));
        alertDialog.setMessage(getString(R.string.errorDesc));

        alertDialog.setButton(getString(R.string.blinkidOK), new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (dialog != null) {
                    dialog.dismiss();
                }
                setResult(Activity.RESULT_CANCELED, null);
                finish();
            }
        });
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    private void displayText(final int textId) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mStatusTextView.setText(textId);
            }
        });
    }

    @Override
    public void onAutofocusFailed() {
        // this method is called if camera cannot perform autofocus
        // this method is called from background (focusing) thread
        // so make sure you post UI actions on UI thread
        displayText(R.string.mb_autofocus_fail);
    }

    @Override
    public void onAutofocusStarted(Rect[] rects) {
        if (rects == null) {
            Log.i(TAG, "Autofocus started with focusing areas being null");
        } else {
            Log.i(TAG, "Autofocus started");
            for (Rect rect : rects) {
                Log.d(TAG, "Focus area: " + rect.toString());
            }
        }
    }

    @Override
    public void onAutofocusStopped(Rect[] rects) {
        if (rects == null) {
            Log.i(TAG, "Autofocus stopped with focusing areas being null");
        } else {
            Log.i(TAG, "Autofocus stopped");
            for (Rect rect : rects) {
                Log.d(TAG, "Focus area: " + rect.toString());
            }
        }
    }

    @Override
    public void onSizeChanged(int width, int height) {
        // this is called whenever size of the BlinkIDView changes
        // we will use this callback in this example to adjust the margins of buttons
        int horizontalMargin = (int) (width * 0.07);
        int verticalMargin = (int) (height * 0.07);

        // set margins for text view
        FrameLayout.LayoutParams statusViewParams = (FrameLayout.LayoutParams) mStatusTextView.getLayoutParams();
        if (statusViewParams.bottomMargin != verticalMargin) {
            statusViewParams.setMargins(horizontalMargin, verticalMargin, horizontalMargin, verticalMargin);
            mStatusTextView.setLayoutParams(statusViewParams);
        }
    }

    @Override
    @TargetApi(23)
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // on API level 23, request permission result should be passed to camera permission manager
        mCameraPermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    @TargetApi(23)
    public void onCameraPermissionDenied() {
        // this method is called on Android 6.0 and newer if camera permission was not given by user

        // ask user to give a camera permission. Provided manager asks for
        // permission only if it has not been already granted.
        // on API level < 23, this method does nothing
        mCameraPermissionManager.askForCameraPermission();
    }
}