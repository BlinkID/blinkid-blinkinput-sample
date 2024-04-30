package com.microblink.blinkid.result.extract.blinkidcustom.sweden;


import com.microblink.blinkid.entities.recognizers.blinkid.sweden.SwedenDlFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class SwedenDlFrontRecognitionResultExtractor extends BlinkIdExtractor<SwedenDlFrontRecognizer.Result, SwedenDlFrontRecognizer> {
    @Override
    protected void extractData(SwedenDlFrontRecognizer.Result result) {
        add(R.string.PPLicenceNumber, result.getLicenceNumber());
        add(R.string.PPSurname, result.getSurname());
        add(R.string.PPName, result.getName());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPIssuingAgency, result.getIssuingAgency());
        add(R.string.PPReferenceNumber, result.getReferenceNumber());
        add(R.string.PPLicenceCategories, result.getLicenceCategories());
    }
}
