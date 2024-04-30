package com.microblink.blinkid.result.extract.blinkidcustom.vin;

import com.microblink.blinkid.entities.recognizers.blinkbarcode.vin.VinRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.BaseResultExtractor;

public class VinRecognitionResultExtractor extends BaseResultExtractor<VinRecognizer.Result, VinRecognizer> {

    @Override
    protected void extractData(VinRecognizer.Result result) {
        add(R.string.PPVin, result.getVin());
    }
}