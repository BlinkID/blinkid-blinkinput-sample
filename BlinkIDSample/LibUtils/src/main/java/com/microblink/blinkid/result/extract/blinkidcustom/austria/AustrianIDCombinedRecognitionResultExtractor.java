package com.microblink.blinkid.result.extract.blinkidcustom.austria;

import com.microblink.blinkid.entities.recognizers.blinkid.austria.AustriaCombinedRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class AustrianIDCombinedRecognitionResultExtractor extends BlinkIdExtractor<AustriaCombinedRecognizer.Result,AustriaCombinedRecognizer> {

    @Override
    protected void extractData(AustriaCombinedRecognizer.Result result) {
        add(R.string.PPLastName, result.getSurname());
        add(R.string.PPFirstName, result.getGivenName());
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPHeight, result.getHeight());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPIssuingAuthority, result.getIssuingAuthority());
        add(R.string.PPIssueDate, result.getDateOfIssuance());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPPrincipalResidenceAtIssuance, result.getPrincipalResidence());
        add(R.string.PPEyeColour, result.getEyeColour());
        add(R.string.PPNationality, result.getNationality());
        add(R.string.PPMRZVerified, result.isMrtdVerified());
        add(R.string.PPDocumentBothSidesMatch, result.getDocumentDataMatch().name());
    }


}
