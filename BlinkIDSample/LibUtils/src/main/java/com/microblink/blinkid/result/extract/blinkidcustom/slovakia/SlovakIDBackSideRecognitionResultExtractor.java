package com.microblink.blinkid.result.extract.blinkidcustom.slovakia;

import com.microblink.blinkid.entities.recognizers.blinkid.slovakia.SlovakiaIdBackRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class SlovakIDBackSideRecognitionResultExtractor extends BlinkIdExtractor<SlovakiaIdBackRecognizer.Result, SlovakiaIdBackRecognizer> {

    @Override
    protected void extractData(SlovakiaIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPSurnameAtBirth, result.getSurnameAtBirth());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPSpecialRemarks, result.getSpecialRemarks());
    }

}
