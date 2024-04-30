package com.microblink.blinkid.result.extract.blinkidcustom.unitedArabEmirates;

import com.microblink.blinkid.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesDlFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class UnitedArabEmiratesDlFrontRecognitionResultExtractor
        extends BlinkIdExtractor<UnitedArabEmiratesDlFrontRecognizer.Result, UnitedArabEmiratesDlFrontRecognizer> {

    @Override
    protected void extractData(UnitedArabEmiratesDlFrontRecognizer.Result result) {
        add(R.string.PPLicenceNumber, result.getLicenseNumber());
        add(R.string.PPLicencingAuthority, result.getLicensingAuthority());
        add(R.string.PPFullName, result.getName());
        add(R.string.PPNationality, result.getNationality());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPIssueDate, result.getIssueDate());
        add(R.string.PPDateOfExpiry, result.getExpiryDate());
        add(R.string.PPPlaceOfIssue, result.getPlaceOfIssue());
    }
}
