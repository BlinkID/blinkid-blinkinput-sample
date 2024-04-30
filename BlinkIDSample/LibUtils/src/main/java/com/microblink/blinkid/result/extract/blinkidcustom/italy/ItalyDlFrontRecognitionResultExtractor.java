package com.microblink.blinkid.result.extract.blinkidcustom.italy;

import com.microblink.blinkid.entities.recognizers.blinkid.italy.ItalyDlFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class ItalyDlFrontRecognitionResultExtractor extends BlinkIdExtractor<ItalyDlFrontRecognizer.Result, ItalyDlFrontRecognizer> {

    @Override
    protected void extractData(ItalyDlFrontRecognizer.Result result) {
        add(R.string.PPSurname, result.getSurname());
        add(R.string.PPFirstName, result.getGivenName());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPIssuingAuthority, result.getIssuingAuthority());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPLicenceNumber, result.getLicenceNumber());
        add(R.string.PPLicenceCategories, result.getLicenceCategories());
        add(R.string.PPAddress, result.getAddress());
    }

}