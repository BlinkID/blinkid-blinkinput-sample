package com.microblink.blinkid.result.extract.blinkidcustom.unitedArabEmirates;

import com.microblink.blinkid.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIdBackRecognizer;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class UnitedArabEmiratesIDBackRecognitionResultExtractor extends BlinkIdExtractor<UnitedArabEmiratesIdBackRecognizer.Result, UnitedArabEmiratesIdBackRecognizer> {

    @Override
    protected void extractData(UnitedArabEmiratesIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
    }

}

