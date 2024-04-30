package com.microblink.blinkid.result.extract.blinkidcustom.mexico;

import com.microblink.blinkid.entities.recognizers.blinkid.mexico.MexicoVoterIdFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class MexicoVoterIdFrontRecognitionResultExtractor extends BlinkIdExtractor<MexicoVoterIdFrontRecognizer.Result, MexicoVoterIdFrontRecognizer> {

    @Override
    protected void extractData(MexicoVoterIdFrontRecognizer.Result result) {
        add(R.string.PPFullName, result.getFullName());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPElectorKey, result.getElectorKey());
        add(R.string.PPCURP, result.getCurp());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPSex, result.getSex());
    }
}
