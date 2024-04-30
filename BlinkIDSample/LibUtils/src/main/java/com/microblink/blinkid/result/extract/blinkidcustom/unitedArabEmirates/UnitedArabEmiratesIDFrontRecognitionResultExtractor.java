package com.microblink.blinkid.result.extract.blinkidcustom.unitedArabEmirates;

import com.microblink.blinkid.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIdFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class UnitedArabEmiratesIDFrontRecognitionResultExtractor extends BlinkIdExtractor<UnitedArabEmiratesIdFrontRecognizer.Result, UnitedArabEmiratesIdFrontRecognizer> {

    @Override
    protected void extractData(UnitedArabEmiratesIdFrontRecognizer.Result result) {
        add(R.string.PPIdentityCardNumber, result.getIdNumber());
        add(R.string.PPName, result.getName());
        add(R.string.PPNationality, result.getNationality());
    }

}