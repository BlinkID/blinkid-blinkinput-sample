package com.microblink.blinkid.result.extract.blinkidcustom.belgium;

import com.microblink.blinkid.entities.recognizers.blinkid.belgium.BelgiumIdFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class BelgiumIdFrontRecognizerResultExtractor extends BlinkIdExtractor<BelgiumIdFrontRecognizer.Result, BelgiumIdFrontRecognizer> {

    @Override
    protected void extractData(BelgiumIdFrontRecognizer.Result belgiumIdFrontRecognizerResult) {
        add(R.string.PPIdentityCardNumber, belgiumIdFrontRecognizerResult.getCardNumber());
    }

}
