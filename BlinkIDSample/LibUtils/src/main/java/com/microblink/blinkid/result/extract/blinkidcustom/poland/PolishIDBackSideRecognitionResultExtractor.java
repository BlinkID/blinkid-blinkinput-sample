package com.microblink.blinkid.result.extract.blinkidcustom.poland;

import com.microblink.blinkid.entities.recognizers.blinkid.poland.PolandIdBackRecognizer;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class PolishIDBackSideRecognitionResultExtractor extends BlinkIdExtractor<PolandIdBackRecognizer.Result, PolandIdBackRecognizer> {

    @Override
    protected void extractData(PolandIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
    }

}
