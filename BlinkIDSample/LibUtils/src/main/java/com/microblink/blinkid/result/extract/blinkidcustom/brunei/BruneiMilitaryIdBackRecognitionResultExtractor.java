package com.microblink.blinkid.result.extract.blinkidcustom.brunei;

import com.microblink.blinkid.entities.recognizers.blinkid.brunei.BruneiMilitaryIdBackRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class BruneiMilitaryIdBackRecognitionResultExtractor extends BlinkIdExtractor<BruneiMilitaryIdBackRecognizer.Result, BruneiMilitaryIdBackRecognizer> {

    @Override
    protected void extractData(BruneiMilitaryIdBackRecognizer.Result result) {
        add(R.string.PPArmyNumber, result.getArmyNumber());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
    }

}
