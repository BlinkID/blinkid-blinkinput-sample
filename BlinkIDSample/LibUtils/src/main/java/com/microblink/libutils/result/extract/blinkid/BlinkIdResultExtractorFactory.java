package com.microblink.libutils.result.extract.blinkid;

import com.microblink.blinkid.entities.recognizers.blinkid.generic.BlinkIdMultiSideRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.BlinkIdSingleSideRecognizer;
import com.microblink.libutils.result.extract.BaseResultExtractorFactory;
import com.microblink.libutils.result.extract.blinkid.generic.BlinkIdMultiSideRecognizerResultExtractor;
import com.microblink.libutils.result.extract.blinkid.generic.BlinkIdSingleSideRecognizerResultExtractor;

public class BlinkIdResultExtractorFactory extends BaseResultExtractorFactory {

    @Override
    protected void addExtractors() {
        add(BlinkIdSingleSideRecognizer.class,
                new BlinkIdSingleSideRecognizerResultExtractor());
        add(BlinkIdMultiSideRecognizer.class,
                new BlinkIdMultiSideRecognizerResultExtractor());
    }
}
