package com.microblink.blinkid.result.extract.blinkidcustom.austria;

import com.microblink.blinkid.entities.recognizers.blinkid.austria.AustriaIdBackRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class AustrianIDBackSideRecognitionResultExtractor extends BlinkIdExtractor<AustriaIdBackRecognizer.Result, AustriaIdBackRecognizer> {

    @Override
    protected void extractData(AustriaIdBackRecognizer.Result ausIDBackResult) {
        extractMRZResult(ausIDBackResult.getMrzResult());

        add(R.string.PPHeight, ausIDBackResult.getHeight());
        add(R.string.PPPlaceOfBirth, ausIDBackResult.getPlaceOfBirth());
        add(R.string.PPIssuingAuthority, ausIDBackResult.getIssuingAuthority());
        add(R.string.PPIssueDate, ausIDBackResult.getDateOfIssuance());
        add(R.string.PPPrincipalResidenceAtIssuance, ausIDBackResult.getPrincipalResidence());
        add(R.string.PPEyeColour, ausIDBackResult.getEyeColour());
        add(R.string.PPDocumentNumber, ausIDBackResult.getDocumentNumber());
    }

}
