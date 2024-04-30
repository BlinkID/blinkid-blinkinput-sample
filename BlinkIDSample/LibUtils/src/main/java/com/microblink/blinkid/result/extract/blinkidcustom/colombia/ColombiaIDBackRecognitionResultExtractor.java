package com.microblink.blinkid.result.extract.blinkidcustom.colombia;

import com.microblink.blinkid.entities.recognizers.blinkid.colombia.ColombiaIdBackRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

import java.util.Arrays;


public class ColombiaIDBackRecognitionResultExtractor extends BlinkIdExtractor<ColombiaIdBackRecognizer.Result, ColombiaIdBackRecognizer> {

    @Override
    protected void extractData(ColombiaIdBackRecognizer.Result result) {
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPDateOfBirth, result.getBirthDate());
        add(R.string.PPBloodGroup, result.getBloodGroup());
        add(R.string.PPFingerprint, Arrays.toString(result.getFingerprint()));
    }

}
