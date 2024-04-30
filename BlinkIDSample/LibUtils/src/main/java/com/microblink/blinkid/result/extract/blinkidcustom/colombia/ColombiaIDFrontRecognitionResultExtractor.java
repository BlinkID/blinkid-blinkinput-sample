package com.microblink.blinkid.result.extract.blinkidcustom.colombia;

import com.microblink.blinkid.entities.recognizers.blinkid.colombia.ColombiaIdFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class ColombiaIDFrontRecognitionResultExtractor extends BlinkIdExtractor<ColombiaIdFrontRecognizer.Result, ColombiaIdFrontRecognizer> {

    @Override
    protected void extractData(ColombiaIdFrontRecognizer.Result result) {
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPFirstName, result.getLastName());
        add(R.string.PPLastName, result.getFirstName());
    }

}
