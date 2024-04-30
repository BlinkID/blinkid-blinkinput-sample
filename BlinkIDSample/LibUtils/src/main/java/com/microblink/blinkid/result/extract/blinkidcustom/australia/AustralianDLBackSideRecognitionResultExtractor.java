package com.microblink.blinkid.result.extract.blinkidcustom.australia;

import com.microblink.blinkid.entities.recognizers.blinkid.australia.AustraliaDlBackRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class AustralianDLBackSideRecognitionResultExtractor extends BlinkIdExtractor<AustraliaDlBackRecognizer.Result, AustraliaDlBackRecognizer> {

    @Override
    protected void extractData(AustraliaDlBackRecognizer.Result result) {
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPLicenceNumber, result.getLicenceNumber());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPDateOfExpiry, result.getLicenceExpiry());
    }

}
