package com.microblink.blinkid.result.extract.blinkidcustom.singapore;

import com.microblink.blinkid.entities.recognizers.blinkid.singapore.SingaporeIdBackRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class SingaporeIDBackRecognitionResultExtractor extends BlinkIdExtractor<SingaporeIdBackRecognizer.Result, SingaporeIdBackRecognizer> {

    @Override
    protected void extractData(SingaporeIdBackRecognizer.Result result) {
        add(R.string.PPDocumentNumber, result.getCardNumber());
        add(R.string.PPBloodGroup, result.getBloodGroup());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPAddressChangeDate, result.getAddressChangeDate());
    }

}