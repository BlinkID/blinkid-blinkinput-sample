package com.microblink.blinkid.result.extract.blinkcard;

import com.microblink.blinkid.entities.recognizers.blinkcard.BlinkCardRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkcard.legacy.LegacyBlinkCardEliteRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkcard.legacy.LegacyBlinkCardRecognizer;
import com.microblink.blinkid.result.extract.BaseResultExtractorFactory;

public class BlinkCardResultExtractorFactory extends BaseResultExtractorFactory {
    @Override
    protected void addExtractors() {
        add(BlinkCardRecognizer.class,
                new BlinkCardRecognizerResultExtractor());
        add(LegacyBlinkCardRecognizer.class,
                new LegacyBlinkCardRecognitionResultExtractor());
        add(LegacyBlinkCardEliteRecognizer.class,
                new LegacyBlinkCardEliteRecognitionResultExtractor());
    }
}
