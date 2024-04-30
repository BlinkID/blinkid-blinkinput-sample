package com.microblink.blinkid.result.extract.blinkidcustom.czechia;

import com.microblink.blinkid.entities.recognizers.blinkid.czechia.CzechiaIdFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class CzechIDFrontSideRecognitionResultExtractor extends BlinkIdExtractor<CzechiaIdFrontRecognizer.Result, CzechiaIdFrontRecognizer> {

    @Override
    protected void extractData(CzechiaIdFrontRecognizer.Result result) {
        add(R.string.PPSurname, result.getSurname());
        add(R.string.PPGivenNames, result.getGivenNames());
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
    }

}
