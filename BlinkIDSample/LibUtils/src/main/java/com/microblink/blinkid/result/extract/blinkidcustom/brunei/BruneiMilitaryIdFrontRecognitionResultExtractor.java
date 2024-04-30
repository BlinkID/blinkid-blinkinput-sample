package com.microblink.blinkid.result.extract.blinkidcustom.brunei;

import com.microblink.blinkid.entities.recognizers.blinkid.brunei.BruneiMilitaryIdFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class BruneiMilitaryIdFrontRecognitionResultExtractor extends BlinkIdExtractor<BruneiMilitaryIdFrontRecognizer.Result, BruneiMilitaryIdFrontRecognizer> {

    @Override
    protected void extractData(BruneiMilitaryIdFrontRecognizer.Result result) {
        add(R.string.PPRank, result.getRank());
        add(R.string.PPFullName, result.getFullName());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
    }

}
