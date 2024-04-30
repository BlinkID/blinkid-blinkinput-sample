package com.microblink.blinkid.result.extract.blinkidcustom.belgium;

import com.microblink.blinkid.entities.recognizers.blinkid.belgium.BelgiumCombinedRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class BelgiumCombinedRecognizerResultExtractor extends BlinkIdExtractor<BelgiumCombinedRecognizer.Result, BelgiumCombinedRecognizer> {

    @Override
    protected void extractData(BelgiumCombinedRecognizer.Result result) {
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPIdentityCardNumber, result.getCardNumber());
        add(R.string.PPNationality, result.getNationality());
        add(R.string.PPNationalNumber, result.getNationalRegisterNumber());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPIssuingAuthority, result.getIssuedBy());
        add(R.string.PPMRZVerified, result.isMrzVerified());
        add(R.string.PPDocumentBothSidesMatch, result.getDocumentDataMatch().name());
    }


}
