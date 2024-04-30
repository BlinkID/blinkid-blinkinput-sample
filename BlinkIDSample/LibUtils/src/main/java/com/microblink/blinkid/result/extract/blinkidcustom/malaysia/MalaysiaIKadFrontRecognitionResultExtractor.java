package com.microblink.blinkid.result.extract.blinkidcustom.malaysia;

import  com.microblink.blinkid.entities.recognizers.blinkid.malaysia.MalaysiaIkadFrontRecognizer;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;
import com.microblink.blinkid.libutils.R;

public class MalaysiaIKadFrontRecognitionResultExtractor extends BlinkIdExtractor<MalaysiaIkadFrontRecognizer.Result, MalaysiaIkadFrontRecognizer> {
    @Override
    protected void extractData(MalaysiaIkadFrontRecognizer.Result result) {
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPName, result.getName());
        add(R.string.PPPassportNumber, result.getPassportNumber());
        add(R.string.PPNationality, result.getNationality());
        add(R.string.PPSex, result.getGender());
        add(R.string.PPSector, result.getSector());
        add(R.string.PPEmployer, result.getEmployer());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPFacultyAddress, result.getFacultyAddress());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
    }

}
