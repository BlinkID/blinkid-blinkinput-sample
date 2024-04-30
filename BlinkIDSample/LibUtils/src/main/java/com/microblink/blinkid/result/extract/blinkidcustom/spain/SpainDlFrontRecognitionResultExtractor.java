package com.microblink.blinkid.result.extract.blinkidcustom.spain;

import com.microblink.blinkid.entities.recognizers.blinkid.spain.SpainDlFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class SpainDlFrontRecognitionResultExtractor extends BlinkIdExtractor<SpainDlFrontRecognizer.Result, SpainDlFrontRecognizer> {

    @Override
    protected void extractData(SpainDlFrontRecognizer.Result result) {
        add(R.string.PPLastName, result.getSurname());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPValidFrom, result.getValidFrom());
        add(R.string.PPValidUntil, result.getValidUntil());
        add(R.string.PPIssuingAuthority, result.getIssuingAuthority());
        add(R.string.PPDocumentNumber, result.getNumber());
        add(R.string.PPLicenceCategories, result.getLicenceCategories());
    }
}
