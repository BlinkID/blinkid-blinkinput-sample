package com.microblink.blinkid.result.extract.blinkidcustom.switzerland;

import com.microblink.blinkid.entities.recognizers.blinkid.switzerland.SwitzerlandDlFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class SwissDLFrontSideRecognitionResultExtractor extends BlinkIdExtractor<SwitzerlandDlFrontRecognizer.Result, SwitzerlandDlFrontRecognizer> {
    @Override
    protected void extractData(SwitzerlandDlFrontRecognizer.Result result) {
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPDocumentNumber, result.getLicenseNumber());
        add(R.string.PPIssuingAuthority, result.getIssuingAuthority());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPDateOfExpiryPermanent, result.isExpiryDatePermanent());
        add(R.string.PPLicenceCategories, result.getVehicleCategories());
    }
}
