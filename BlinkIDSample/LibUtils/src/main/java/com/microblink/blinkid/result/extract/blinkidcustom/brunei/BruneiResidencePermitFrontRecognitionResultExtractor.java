package com.microblink.blinkid.result.extract.blinkidcustom.brunei;

import com.microblink.blinkid.libutils.R;

import com.microblink.blinkid.entities.recognizers.blinkid.brunei.BruneiResidencePermitFrontRecognizer;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class BruneiResidencePermitFrontRecognitionResultExtractor extends BlinkIdExtractor<BruneiResidencePermitFrontRecognizer.Result, BruneiResidencePermitFrontRecognizer> {
    @Override
    protected void extractData(BruneiResidencePermitFrontRecognizer.Result result) {
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPFullName, result.getFullName());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
    }
}
