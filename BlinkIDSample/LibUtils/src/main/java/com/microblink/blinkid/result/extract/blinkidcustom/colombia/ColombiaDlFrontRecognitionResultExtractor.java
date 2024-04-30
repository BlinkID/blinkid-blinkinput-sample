package com.microblink.blinkid.result.extract.blinkidcustom.colombia;

import com.microblink.blinkid.entities.recognizers.blinkid.colombia.ColombiaDlFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class ColombiaDlFrontRecognitionResultExtractor extends BlinkIdExtractor<ColombiaDlFrontRecognizer.Result, ColombiaDlFrontRecognizer> {

    @Override
    protected void extractData(ColombiaDlFrontRecognizer.Result result) {
        add(R.string.PPLicenceNumber, result.getLicenceNumber());
        add(R.string.PPName, result.getName());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPAdditionalInformation, result.getDriverRestrictions());
        add(R.string.PPIssuingAgency, result.getIssuingAgency());
    }

}
