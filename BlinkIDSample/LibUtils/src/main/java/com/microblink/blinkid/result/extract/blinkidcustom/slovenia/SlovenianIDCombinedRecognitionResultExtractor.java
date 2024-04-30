package com.microblink.blinkid.result.extract.blinkidcustom.slovenia;

import com.microblink.blinkid.entities.recognizers.blinkid.slovenia.SloveniaCombinedRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class SlovenianIDCombinedRecognitionResultExtractor extends BlinkIdExtractor<SloveniaCombinedRecognizer.Result, SloveniaCombinedRecognizer> {

    @Override
    protected void extractData(SloveniaCombinedRecognizer.Result result) {
        add(R.string.PPSurname, result.getSurname());
        add(R.string.PPGivenNames, result.getGivenNames());
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPNationality, result.getNationality());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPDateOfExpiryPermanent, result.isDateOfExpiryPermanent());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPAdministrativeUnit, result.getAdministrativeUnit());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPPersonalNumber, result.getPin());
        add(R.string.PPMRZVerified, result.isMrzVerified());
        add(R.string.PPDocumentBothSidesMatch, result.getDocumentDataMatch().name());
    }

}
