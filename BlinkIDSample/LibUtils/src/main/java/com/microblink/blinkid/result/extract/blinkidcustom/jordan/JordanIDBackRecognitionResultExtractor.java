package com.microblink.blinkid.result.extract.blinkidcustom.jordan;

import com.microblink.blinkid.entities.recognizers.blinkid.jordan.JordanIdBackRecognizer;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class JordanIDBackRecognitionResultExtractor extends BlinkIdExtractor<JordanIdBackRecognizer.Result, JordanIdBackRecognizer> {

    @Override
    protected void extractData(JordanIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
    }

}