package com.microblink.blinkid.result.extract.blinkidcustom.slovenia;

import com.microblink.blinkid.entities.recognizers.blinkid.slovenia.SloveniaIdFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class SlovenianIDFrontSideRecognitionResultExtractor extends BlinkIdExtractor<SloveniaIdFrontRecognizer.Result, SloveniaIdFrontRecognizer> {

    @Override
    protected void extractData(SloveniaIdFrontRecognizer.Result sloIdFrontResult) {
        add(R.string.PPSurname, sloIdFrontResult.getSurname());
        add(R.string.PPGivenNames, sloIdFrontResult.getGivenNames());
        add(R.string.PPSex, sloIdFrontResult.getSex());
        add(R.string.PPNationality, sloIdFrontResult.getNationality());
        add(R.string.PPDateOfBirth, sloIdFrontResult.getDateOfBirth());
        add(R.string.PPDateOfExpiry, sloIdFrontResult.getDateOfExpiry());
        add(R.string.PPDateOfExpiryPermanent, sloIdFrontResult.isDateOfExpiryPermanent());
    }

}
