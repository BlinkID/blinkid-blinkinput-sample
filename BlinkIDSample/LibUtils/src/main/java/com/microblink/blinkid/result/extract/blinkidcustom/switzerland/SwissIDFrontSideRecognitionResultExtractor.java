package com.microblink.blinkid.result.extract.blinkidcustom.switzerland;

import com.microblink.blinkid.entities.recognizers.blinkid.switzerland.SwitzerlandIdFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class SwissIDFrontSideRecognitionResultExtractor extends BlinkIdExtractor<SwitzerlandIdFrontRecognizer.Result, SwitzerlandIdFrontRecognizer> {

    @Override
    protected void extractData(SwitzerlandIdFrontRecognizer.Result result) {
        add(R.string.PPLastName, result.getSurname());
        add(R.string.PPFirstName, result.getGivenName());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
    }

}

