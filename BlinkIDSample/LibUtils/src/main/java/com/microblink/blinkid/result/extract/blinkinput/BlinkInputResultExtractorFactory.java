package com.microblink.blinkid.result.extract.blinkinput;

import com.microblink.blinkinput.entities.recognizers.blinkbarcode.barcode.BarcodeRecognizer;
import com.microblink.blinkinput.entities.recognizers.blinkinput.documentcapture.DocumentCaptureRecognizer;
import com.microblink.blinkinput.entities.recognizers.detector.DetectorRecognizer;
import com.microblink.blinkid.result.extract.BaseResultExtractorFactory;
import com.microblink.blinkid.result.extract.pdf417mobi.BarcodeRecognitionResultExtractor;

public class BlinkInputResultExtractorFactory extends BaseResultExtractorFactory {

    @Override
    protected void addExtractors() {
        add(DetectorRecognizer.class,
                new DetectorRecognitionResultExtractor());
        add(BarcodeRecognizer.class,
                new BarcodeRecognitionResultExtractor());

        add(DocumentCaptureRecognizer.class,
                new DocumentCaptureResultExtractor()
        );
    }

}
