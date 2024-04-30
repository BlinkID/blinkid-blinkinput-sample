package com.microblink.blinkid.result.extract.pdf417mobi;

import com.microblink.blinkid.entities.recognizers.blinkbarcode.simnumber.SimNumberRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.BaseResultExtractor;

public class SimNumberRecognitionResultExtractor extends BaseResultExtractor<SimNumberRecognizer.Result, SimNumberRecognizer> {

    @Override
    protected void extractData(SimNumberRecognizer.Result result) {
        add(R.string.PPSimNumber, result.getSimNumber());
    }
}