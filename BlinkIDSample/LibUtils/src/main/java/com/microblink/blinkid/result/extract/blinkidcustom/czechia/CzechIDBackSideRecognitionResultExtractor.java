package com.microblink.blinkid.result.extract.blinkidcustom.czechia;

import com.microblink.blinkid.entities.recognizers.blinkid.czechia.CzechiaIdBackRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class CzechIDBackSideRecognitionResultExtractor extends BlinkIdExtractor<CzechiaIdBackRecognizer.Result, CzechiaIdBackRecognizer> {

    @Override
    protected void extractData(CzechiaIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
        add(R.string.PPAddress, result.getPermanentStay());
        add(R.string.PPPersonalNumber, result.getPersonalNumber());
        add(R.string.PPAuthority, result.getAuthority());
    }

}
