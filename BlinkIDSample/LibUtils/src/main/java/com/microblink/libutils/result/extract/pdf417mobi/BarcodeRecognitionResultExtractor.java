package com.microblink.libutils.result.extract.pdf417mobi;

import com.microblink.libutils.result.extract.adapters.blinkinput.BlinkInputRecognizer;
import com.microblink.blinkinput.entities.recognizers.blinkbarcode.barcode.BarcodeRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.libutils.result.extract.BaseResultExtractor;

import java.util.Arrays;

public class BarcodeRecognitionResultExtractor extends BaseResultExtractor<
        BarcodeRecognizer.Result,
        BarcodeRecognizer,
        BlinkInputRecognizer<BarcodeRecognizer.Result, BarcodeRecognizer>> {

    @Override
    protected void extractData(BarcodeRecognizer.Result result) {
        add(R.string.PPBarcodeType, result.getBarcodeType().name());
        add(R.string.PPUncertain, result.isUncertain());
        add(R.string.PPBarcodeData, result.getStringData());
        byte[] rawDataBytes = result.getRawData();
        add(R.string.PPBarcodeRawData, Arrays.toString(rawDataBytes));
    }

}
