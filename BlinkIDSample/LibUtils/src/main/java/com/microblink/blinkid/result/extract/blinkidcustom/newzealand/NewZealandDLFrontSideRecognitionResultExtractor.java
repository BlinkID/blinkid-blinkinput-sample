package com.microblink.blinkid.result.extract.blinkidcustom.newzealand;

import com.microblink.blinkid.entities.recognizers.blinkid.newzealand.NewZealandDlFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class NewZealandDLFrontSideRecognitionResultExtractor extends BlinkIdExtractor<NewZealandDlFrontRecognizer.Result, NewZealandDlFrontRecognizer> {

    @Override
    protected void extractData(NewZealandDlFrontRecognizer.Result result) {
        add(R.string.PPSurname, result.getSurname());
        add(R.string.PPFirstNames, result.getFirstNames());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPLicenceNumber, result.getLicenseNumber());
        add(R.string.PPCardVersion, result.getCardVersion());
        add(R.string.PPDonorIndicator, result.isDonorIndicator());
        add(R.string.PPAddress, result.getAddress());
    }

}