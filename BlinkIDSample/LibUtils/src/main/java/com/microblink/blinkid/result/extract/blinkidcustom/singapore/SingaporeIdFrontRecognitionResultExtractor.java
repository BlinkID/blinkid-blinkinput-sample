package com.microblink.blinkid.result.extract.blinkidcustom.singapore;

import com.microblink.blinkid.entities.recognizers.blinkid.singapore.SingaporeIdFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class SingaporeIdFrontRecognitionResultExtractor extends BlinkIdExtractor<SingaporeIdFrontRecognizer.Result, SingaporeIdFrontRecognizer> {

    @Override
    protected void extractData(SingaporeIdFrontRecognizer.Result result) {
        add(R.string.PPIdentityCardNumber, result.getIdentityCardNumber());
        add(R.string.PPFullName, result.getName());
        add(R.string.PPRace, result.getRace());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPCountryOfBirth, result.getCountryOfBirth());
    }

}