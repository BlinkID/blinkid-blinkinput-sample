package com.microblink.blinkid.result.activity.fragment;

import android.app.Activity;
import android.content.Context;

import com.microblink.blinkid.entities.recognizers.blinkinput.documentcapture.DocumentCaptureRecognizer;
import com.microblink.blinkid.image.highres.HighResImageWrapper;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.ResultSource;
import com.microblink.blinkid.result.extract.RecognitionResultEntry;
import com.microblink.blinkid.result.extract.blinkinput.DocumentCaptureResultExtractor;
import com.microblink.blinkid.util.Log;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DocumentCaptureResultFragment extends BaseResultFragment {
    /**
     * Fragment factory.
     */
    public static DocumentCaptureResultFragment newInstance() {
        DocumentCaptureResultFragment fragment = new DocumentCaptureResultFragment();

        Log.d("DocumentCaptureResultFragment", "Creating new fragment");

        return fragment;
    }

    @Override
    protected void checkHostActivity(Activity hostActivity) {
        if ( !(hostActivity instanceof ResultFragmentActivity) ) {
            throw new ClassCastException("ResultFragment must be used inside activity which"
                    + " implements ResultFragment.ResultFragmentActivity interface");
        }
    }

    @Override
    protected List<RecognitionResultEntry> createResultEntries(Context context) {
        // this must be called after the activity has been created

        DocumentCaptureRecognizer recognizer =
                ((ResultFragmentActivity) getActivity()).getRecognizer();

        DocumentCaptureResultExtractor resultExtractor = new DocumentCaptureResultExtractor();
        List<RecognitionResultEntry> extractedData = resultExtractor.extractData(getActivity(), recognizer, ResultSource.MIXED);

        HighResImageWrapper capturedImageWrapper = ((ResultFragmentActivity) getActivity()).getCapturedImage();
        if (capturedImageWrapper != null) {
            RecognitionResultEntry.Builder builder = new RecognitionResultEntry.Builder(getActivity());
            extractedData.add(builder.build(R.string.MBHighResImage, capturedImageWrapper.getImage()));
        }

        return extractedData;
    }

    /**
     * Interface which must be implemented by all activities that use {@link DocumentCaptureResultFragment}.
     */
    public interface ResultFragmentActivity {
        @NonNull
        DocumentCaptureRecognizer getRecognizer();
        @Nullable
        HighResImageWrapper getCapturedImage();
    }
}
