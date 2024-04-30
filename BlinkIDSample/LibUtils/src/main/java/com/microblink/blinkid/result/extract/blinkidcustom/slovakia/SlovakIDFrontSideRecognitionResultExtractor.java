package com.microblink.blinkid.result.extract.blinkidcustom.slovakia;

import com.microblink.blinkid.entities.recognizers.blinkid.slovakia.SlovakiaIdFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class SlovakIDFrontSideRecognitionResultExtractor  extends BlinkIdExtractor<SlovakiaIdFrontRecognizer.Result, SlovakiaIdFrontRecognizer> {

    @Override
    protected void extractData(SlovakiaIdFrontRecognizer.Result svkIdFrontResult) {
        add(R.string.PPLastName, svkIdFrontResult.getLastName());
        add(R.string.PPFirstName, svkIdFrontResult.getFirstName());
        add(R.string.PPNationality, svkIdFrontResult.getNationality());
        add(R.string.PPSex, svkIdFrontResult.getSex());
        add(R.string.PPDocumentNumber, svkIdFrontResult.getDocumentNumber());
        add(R.string.PPIssuedBy, svkIdFrontResult.getIssuedBy());
        add(R.string.PPDateOfBirth, svkIdFrontResult.getDateOfBirth());
        add(R.string.PPPersonalNumber, svkIdFrontResult.getPersonalNumber());
        add(R.string.PPDateOfExpiry, svkIdFrontResult.getDateOfExpiry());
        add(R.string.PPIssueDate, svkIdFrontResult.getDateOfIssue());
    }

}
