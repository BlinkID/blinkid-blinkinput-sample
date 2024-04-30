package com.microblink.blinkid.result.extract.blinkidcustom.nigeria;

import com.microblink.blinkid.entities.recognizers.blinkid.nigeria.NigeriaCombinedRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class NigeriaCombinedRecognitionResultExtractor extends BlinkIdExtractor<NigeriaCombinedRecognizer.Result, NigeriaCombinedRecognizer> {

    @Override
    protected void extractData(NigeriaCombinedRecognizer.Result result) {
        add(R.string.PPSurname, result.getSurname());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPRawResult, result.getRawBarcodeData());
    }

}