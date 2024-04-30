package com.microblink.blinkid.result.extract.blinkidcustom.croatia;


import com.microblink.blinkid.entities.recognizers.blinkid.croatia.CroatiaCombinedRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class CroatianIDCombinedRecognitionResultExtractor extends BlinkIdExtractor<CroatiaCombinedRecognizer.Result, CroatiaCombinedRecognizer> {

    @Override
    protected void extractData(CroatiaCombinedRecognizer.Result result) {
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPCitizenship, result.getCitizenship());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPDateOfExpiryPermanent, result.isDateOfExpiryPermanent());
        add(R.string.PPAddress, result.getResidence());
        add(R.string.PPDocumentForNonResidents, result.isDocumentForNonResident());
        add(R.string.PPIssuingAuthority, result.getIssuedBy());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPPersonalNumber, result.getOib());
        add(R.string.PPMRZVerified, result.isMrzVerified());
        add(R.string.PPDocumentBothSidesMatch, result.getDocumentDataMatch().name());
        add(R.string.PPDocumentBilingual, result.isDocumentBilingual());
    }

}
