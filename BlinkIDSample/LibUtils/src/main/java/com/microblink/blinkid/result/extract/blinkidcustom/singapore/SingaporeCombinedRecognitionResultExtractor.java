package com.microblink.blinkid.result.extract.blinkidcustom.singapore;

import com.microblink.blinkid.entities.recognizers.blinkid.singapore.SingaporeCombinedRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class SingaporeCombinedRecognitionResultExtractor extends BlinkIdExtractor<SingaporeCombinedRecognizer.Result, SingaporeCombinedRecognizer> {

    @Override
    protected void extractData(SingaporeCombinedRecognizer.Result result) {
        add(R.string.PPIdentityCardNumber, result.getIdentityCardNumber());
        add(R.string.PPFullName, result.getName());
        add(R.string.PPRace, result.getRace());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPCountryOfBirth, result.getCountryOfBirth());
        add(R.string.PPBloodGroup, result.getBloodGroup());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDocumentBothSidesMatch, result.getDocumentDataMatch().name());
    }
}
