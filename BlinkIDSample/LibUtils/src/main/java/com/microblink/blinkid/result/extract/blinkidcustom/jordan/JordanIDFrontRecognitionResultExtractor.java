package com.microblink.blinkid.result.extract.blinkidcustom.jordan;

import com.microblink.blinkid.entities.recognizers.blinkid.jordan.JordanIdFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class JordanIDFrontRecognitionResultExtractor extends BlinkIdExtractor<JordanIdFrontRecognizer.Result, JordanIdFrontRecognizer> {

    @Override
    protected void extractData(JordanIdFrontRecognizer.Result result) {
        add(R.string.PPNationalNumber, result.getNationalNumber());
        add(R.string.PPName, result.getName());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
    }

}
