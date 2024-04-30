package com.microblink.blinkid.result.extract.blinkidcustom.egypt;

import com.microblink.blinkid.entities.recognizers.blinkid.egypt.EgyptIdFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;


public class EgyptIDFrontRecognitionResultExtractor extends BlinkIdExtractor<EgyptIdFrontRecognizer.Result, EgyptIdFrontRecognizer> {

    @Override
    protected void extractData(EgyptIdFrontRecognizer.Result result) {
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPNationalNumber, result.getNationalNumber());
    }

}
