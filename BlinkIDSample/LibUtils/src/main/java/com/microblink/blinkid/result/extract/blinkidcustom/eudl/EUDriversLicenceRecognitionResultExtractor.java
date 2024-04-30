package com.microblink.blinkid.result.extract.blinkidcustom.eudl;

import com.microblink.blinkid.entities.recognizers.blinkid.eudl.EudlRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class EUDriversLicenceRecognitionResultExtractor extends BlinkIdExtractor<EudlRecognizer.Result, EudlRecognizer> {

    @Override
    protected void extractData(EudlRecognizer.Result result) {
       add(R.string.PPFirstName, result.getFirstName());
       add(R.string.PPLastName, result.getLastName());
       add(R.string.PPPersonalNumber, result.getPersonalNumber());
       add(R.string.PPAddress, result.getAddress());
       add(R.string.MBBirthData, result.getBirthData());
       add(R.string.PPIssueDate, result.getIssueDate());
       add(R.string.PPDateOfExpiry, result.getExpiryDate());
       add(R.string.PPDriverNumber, result.getDriverNumber());
       add(R.string.PPIssuingAuthority, result.getIssuingAuthority());
       add(R.string.PPCountryId, result.getCountry().name());
    }

}
