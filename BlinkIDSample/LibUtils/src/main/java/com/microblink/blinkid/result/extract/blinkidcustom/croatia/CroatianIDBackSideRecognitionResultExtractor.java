package com.microblink.blinkid.result.extract.blinkidcustom.croatia;

import com.microblink.blinkid.entities.recognizers.blinkid.croatia.CroatiaIdBackRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class CroatianIDBackSideRecognitionResultExtractor extends BlinkIdExtractor<CroatiaIdBackRecognizer.Result, CroatiaIdBackRecognizer> {

    @Override
    protected void extractData(CroatiaIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());

        add(R.string.PPResidence, result.getResidence());
        add(R.string.PPDocumentForNonResidents, result.isDocumentForNonResident());
        add(R.string.PPIssuingAuthority, result.getIssuedBy());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDateOfExpiryPermanent, result.isDateOfExpiryPermanent());
    }

}
