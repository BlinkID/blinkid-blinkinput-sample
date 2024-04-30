package com.microblink.blinkid.result.extract.blinkidcustom;

import com.microblink.blinkid.entities.recognizers.blinkid.generic.BlinkIdMultiSideRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.BlinkIdSingleSideRecognizer;
import com.microblink.blinkid.result.extract.blinkid.generic.BlinkIdMultiSideRecognizerResultExtractor;
import com.microblink.blinkid.result.extract.blinkid.generic.BlinkIdSingleSideRecognizerResultExtractor;
import com.microblink.blinkid.result.extract.blinkinput.BlinkInputResultExtractorFactory;

public class BlinkIdCustomResultExtractorFactory extends BlinkInputResultExtractorFactory {

    @Override
    protected void addExtractors() {
        super.addExtractors();

        add(BlinkIdSingleSideRecognizer.class,
                new BlinkIdSingleSideRecognizerResultExtractor());
        add(BlinkIdMultiSideRecognizer.class,
                new BlinkIdMultiSideRecognizerResultExtractor());
    }
}
