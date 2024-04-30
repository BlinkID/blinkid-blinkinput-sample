package com.microblink.blinkid.result.extract.blinkidcustom.belgium;

import com.microblink.blinkid.entities.recognizers.blinkid.belgium.BelgiumIdBackRecognizer;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class BelgiumIdBackRecognizerResultExtractor extends BlinkIdExtractor<BelgiumIdBackRecognizer.Result, BelgiumIdBackRecognizer> {
    @Override
    protected void extractData(BelgiumIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
    }
}
