package com.microblink.blinkid.result.extract.blinkidcustom.australia;

import com.microblink.blinkid.entities.recognizers.blinkid.australia.AustraliaDlFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class AustralianDLFrontSideRecognitionResultExtractor extends BlinkIdExtractor<AustraliaDlFrontRecognizer.Result, AustraliaDlFrontRecognizer> {

    @Override
    protected void extractData(AustraliaDlFrontRecognizer.Result result) {
        add(R.string.PPFullName, result.getFullName());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPLicenceNumber, result.getLicenceNumber());
        add(R.string.PPLicenceType, result.getLicenceType());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPDateOfExpiry, result.getLicenceExpiry());
    }

}
