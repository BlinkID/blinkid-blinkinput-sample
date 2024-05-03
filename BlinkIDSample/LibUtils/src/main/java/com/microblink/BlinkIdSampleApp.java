package com.microblink;

import android.app.Application;

import com.microblink.libutils.result.extract.ResultExtractorFactoryProvider;
import com.microblink.libutils.result.extract.blinkidcustom.BlinkIdCustomResultExtractorFactory;

public final class BlinkIdSampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // obtain your licence at http://microblink.com/login or contact us at http://help.microblink.com
        com.microblink.blinkid.MicroblinkSDK.setLicenseFile("com.microblink.blinkid.custom.mblic", this);
        com.microblink.blinkinput.MicroblinkSDK.setLicenseFile("com.microblink.blinkid.custom.mblic", this);

        // use optimised way for transferring RecognizerBundle between activities, while ensuring
        // data does not get lost when Android restarts the scanning activity
        com.microblink.blinkid.MicroblinkSDK.setIntentDataTransferMode(com.microblink.blinkid.intent.IntentDataTransferMode.PERSISTED_OPTIMISED);
        com.microblink.blinkinput.MicroblinkSDK.setIntentDataTransferMode(com.microblink.blinkinput.intent.IntentDataTransferMode.PERSISTED_OPTIMISED);

        ResultExtractorFactoryProvider.set(new BlinkIdCustomResultExtractorFactory());
    }

}
