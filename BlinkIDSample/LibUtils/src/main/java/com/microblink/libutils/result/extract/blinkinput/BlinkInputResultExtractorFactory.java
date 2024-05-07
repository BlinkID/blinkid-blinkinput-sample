package com.microblink.libutils.result.extract.blinkinput;

import com.microblink.blinkinput.entities.recognizers.blinkbarcode.barcode.BarcodeRecognizer;
import com.microblink.blinkinput.entities.recognizers.detector.DetectorRecognizer;
import com.microblink.libutils.result.extract.BaseResultExtractorFactory;
import com.microblink.libutils.result.extract.pdf417mobi.BarcodeRecognitionResultExtractor;

public class BlinkInputResultExtractorFactory extends BaseResultExtractorFactory {

    @Override
    protected void addExtractors() {
        add(DetectorRecognizer.class,
                new DetectorRecognitionResultExtractor());
        add(BarcodeRecognizer.class,
                new BarcodeRecognitionResultExtractor());
    }

}
