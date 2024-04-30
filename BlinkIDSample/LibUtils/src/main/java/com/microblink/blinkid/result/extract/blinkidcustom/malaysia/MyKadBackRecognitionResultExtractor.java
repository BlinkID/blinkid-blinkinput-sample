package com.microblink.blinkid.result.extract.blinkidcustom.malaysia;

import com.microblink.blinkid.entities.recognizers.blinkid.malaysia.MalaysiaMyKadBackRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class MyKadBackRecognitionResultExtractor extends BlinkIdExtractor<MalaysiaMyKadBackRecognizer.Result, MalaysiaMyKadBackRecognizer> {

    @Override
    protected void extractData(MalaysiaMyKadBackRecognizer.Result result) {
        add(R.string.PPNRICNumber, result.getNric());
        add(R.string.PPExtendedNRIC, result.getExtendedNric());
        add(R.string.PPOldNRIC, result.getOldNric());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
    }

}