package com.microblink.blinkid.result.extract.blinkidcustom.cyprus;

import com.microblink.blinkid.entities.recognizers.blinkid.cyprus.CyprusIdBackRecognizer;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class CyprusIdBackRecognitionResultExtractor extends BlinkIdExtractor<CyprusIdBackRecognizer.Result, CyprusIdBackRecognizer> {
    @Override
    protected void extractData(CyprusIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
    }
}
