package com.microblink.blinkid.result.extract.blinkidcustom.cyprus;

import com.microblink.blinkid.entities.recognizers.blinkid.cyprus.CyprusIdFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class CyprusIdFrontRecognitionResultExtractor extends BlinkIdExtractor<CyprusIdFrontRecognizer.Result, CyprusIdFrontRecognizer > {
    @Override
    protected void extractData(CyprusIdFrontRecognizer.Result result) {
        add(R.string.PPIdentityCardNumber, result.getIdNumber());
    }
}
