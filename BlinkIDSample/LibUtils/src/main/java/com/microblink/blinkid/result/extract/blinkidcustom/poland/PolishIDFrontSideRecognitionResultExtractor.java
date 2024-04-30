package com.microblink.blinkid.result.extract.blinkidcustom.poland;

import com.microblink.blinkid.entities.recognizers.blinkid.poland.PolandIdFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class PolishIDFrontSideRecognitionResultExtractor extends BlinkIdExtractor<PolandIdFrontRecognizer.Result, PolandIdFrontRecognizer> {

    @Override
    protected void extractData(PolandIdFrontRecognizer.Result result) {
        add(R.string.PPLastName, result.getSurname());
        add(R.string.PPFirstName, result.getGivenNames());
        addIfNotEmpty(R.string.PPFamilyName, result.getFamilyName());
        addIfNotEmpty(R.string.PPParentNames, result.getParentsGivenNames());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
    }

}

