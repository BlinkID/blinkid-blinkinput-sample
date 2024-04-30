package com.microblink.blinkid.result.extract.blinkidcustom.singapore;

import com.microblink.blinkid.entities.recognizers.blinkid.singapore.SingaporeDlFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class SingaporeDlFrontRecognitionResultExtractor extends BlinkIdExtractor<SingaporeDlFrontRecognizer.Result, SingaporeDlFrontRecognizer> {

    @Override
    protected void extractData(SingaporeDlFrontRecognizer.Result singaporeDlFrontResult) {
        add(R.string.PPLicenceNumber, singaporeDlFrontResult.getLicenceNumber());
        add(R.string.PPName, singaporeDlFrontResult.getName());
        add(R.string.PPDateOfBirth, singaporeDlFrontResult.getBirthDate());
        add(R.string.PPIssueDate, singaporeDlFrontResult.getIssueDate());
        add(R.string.PPValidUntil, singaporeDlFrontResult.getValidTill());
    }
}
