package com.microblink.blinkid.result.extract.blinkidcustom.cyprus;

import com.microblink.blinkid.entities.recognizers.blinkid.cyprus.CyprusOldIdBackRecognizer;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;
import com.microblink.blinkid.libutils.R;

public class CyprusOldIdBackRecognitionResultExtractor extends BlinkIdExtractor< CyprusOldIdBackRecognizer.Result, CyprusOldIdBackRecognizer> {
    @Override
    protected void extractData(CyprusOldIdBackRecognizer.Result result) {
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPDateOfExpiry, result.getExpiresOn());
    }
}
