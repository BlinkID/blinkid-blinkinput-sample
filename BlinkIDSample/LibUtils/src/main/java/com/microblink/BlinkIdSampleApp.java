package com.microblink;

import android.app.Application;

import com.microblink.blinkid.MicroblinkSDK;
import com.microblink.blinkid.intent.IntentDataTransferMode;
import com.microblink.blinkid.result.extract.ResultExtractorFactoryProvider;
import com.microblink.blinkid.result.extract.blinkidcustom.BlinkIdCustomResultExtractorFactory;

public final class BlinkIdSampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // obtain your licence at http://microblink.com/login or contact us at http://help.microblink.com
        MicroblinkSDK.setLicenseFile("com.microblink.blinkid.custom.mblic", this);

        // use optimised way for transferring RecognizerBundle between activities, while ensuring
        // data does not get lost when Android restarts the scanning activity
        MicroblinkSDK.setIntentDataTransferMode(IntentDataTransferMode.PERSISTED_OPTIMISED);

        ResultExtractorFactoryProvider.set(new BlinkIdCustomResultExtractorFactory());
    }

}
