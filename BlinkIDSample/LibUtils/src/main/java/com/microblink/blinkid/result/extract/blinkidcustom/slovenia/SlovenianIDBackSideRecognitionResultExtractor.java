package com.microblink.blinkid.result.extract.blinkidcustom.slovenia;

import com.microblink.blinkid.entities.recognizers.blinkid.slovenia.SloveniaIdBackRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class SlovenianIDBackSideRecognitionResultExtractor extends BlinkIdExtractor<SloveniaIdBackRecognizer.Result, SloveniaIdBackRecognizer> {

    @Override
    protected void extractData(SloveniaIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());

        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPAdministrativeUnit, result.getAdministrativeUnit());
        add(R.string.PPIssueDate, result.getDateOfIssue());
    }

}
