package com.microblink.blinkid.result.extract.blinkidcustom.germany;

import com.microblink.blinkid.entities.recognizers.blinkid.germany.GermanyIdOldRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class GermanOldIDRecognitionResultExtractor extends BlinkIdExtractor<GermanyIdOldRecognizer.Result, GermanyIdOldRecognizer> {

    @Override
    protected void extractData(GermanyIdOldRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
    }

}
