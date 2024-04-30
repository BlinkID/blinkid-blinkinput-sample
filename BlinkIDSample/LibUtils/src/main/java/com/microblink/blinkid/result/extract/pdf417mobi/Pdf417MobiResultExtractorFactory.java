package com.microblink.blinkid.result.extract.pdf417mobi;

import com.microblink.blinkid.entities.recognizers.blinkbarcode.barcode.BarcodeRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkbarcode.pdf417.Pdf417Recognizer;
import com.microblink.blinkid.entities.recognizers.blinkbarcode.simnumber.SimNumberRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkbarcode.usdl.UsdlRecognizer;
import com.microblink.blinkid.entities.recognizers.successframe.SuccessFrameGrabberRecognizer;
import com.microblink.blinkid.result.extract.BaseResultExtractorFactory;
import com.microblink.blinkid.result.extract.usdl.USDLResultExtractor;

public class Pdf417MobiResultExtractorFactory extends BaseResultExtractorFactory {

    @Override
    protected void addExtractors() {
        add(BarcodeRecognizer.class,
                new BarcodeRecognitionResultExtractor());
        add(Pdf417Recognizer.class,
                new Pdf417RecognitionResultExtractor());
        add(SimNumberRecognizer.class,
                new SimNumberRecognitionResultExtractor());
        add(UsdlRecognizer.class,
                new USDLResultExtractor());
    }

}
