package com.microblink.blinkid.result.extract.blinkidcustom.germany;

import com.microblink.blinkid.entities.recognizers.blinkid.germany.GermanyDlFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;


public class GermanyDlFrontSideRecognitionResultExtractor extends BlinkIdExtractor<GermanyDlFrontRecognizer.Result, GermanyDlFrontRecognizer> {

    @Override
    protected void extractData(GermanyDlFrontRecognizer.Result result) {
        add(R.string.PPLicenceNumber, result.getLicenceNumber());
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPIssuingAuthority, result.getIssuingAuthority());
        add(R.string.PPLicenceCategories, result.getLicenceCategories());
    }

}