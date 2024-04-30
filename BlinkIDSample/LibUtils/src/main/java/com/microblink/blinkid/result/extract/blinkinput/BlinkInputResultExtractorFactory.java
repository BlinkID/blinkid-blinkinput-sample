package com.microblink.blinkid.result.extract.blinkinput;

import com.microblink.blinkid.entities.recognizers.blinkbarcode.barcode.BarcodeRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkbarcode.pdf417.Pdf417Recognizer;
import com.microblink.blinkid.entities.recognizers.blinkbarcode.simnumber.SimNumberRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkinput.documentcapture.DocumentCaptureRecognizer;
import com.microblink.blinkid.entities.recognizers.detector.DetectorRecognizer;
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
