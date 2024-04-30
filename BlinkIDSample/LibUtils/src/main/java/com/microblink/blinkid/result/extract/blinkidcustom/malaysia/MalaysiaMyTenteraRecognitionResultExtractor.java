package com.microblink.blinkid.result.extract.blinkidcustom.malaysia;

import com.microblink.blinkid.entities.recognizers.blinkid.malaysia.MalaysiaMyTenteraFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class MalaysiaMyTenteraRecognitionResultExtractor extends BlinkIdExtractor<MalaysiaMyTenteraFrontRecognizer.Result, MalaysiaMyTenteraFrontRecognizer> {

    @Override
    protected void extractData(MalaysiaMyTenteraFrontRecognizer.Result result) {
        add(R.string.PPFullName, result.getFullName());
        add(R.string.PPArmyNumber, result.getArmyNumber());
        add(R.string.PPAddress, result.getFullAddress());
        add(R.string.PPAddressStreet, result.getStreet());
        add(R.string.PPAddressZipCode, result.getZipcode());
        add(R.string.PPAddressCity, result.getCity());
        add(R.string.PPAddressState, result.getOwnerState());
        add(R.string.PPDateOfBirth, result.getBirthDate());

        add(R.string.PPSex, result.getSex());
        add(R.string.PPReligion, result.getReligion());
        add(R.string.PPNRICNumber, result.getNric());
    }

}
