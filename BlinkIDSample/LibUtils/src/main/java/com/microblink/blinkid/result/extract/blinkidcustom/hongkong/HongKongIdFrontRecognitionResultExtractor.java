package com.microblink.blinkid.result.extract.blinkidcustom.hongkong;

import com.microblink.blinkid.entities.recognizers.blinkid.hongkong.HongKongIdFrontRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;
import com.microblink.blinkid.results.date.Date;

public class HongKongIdFrontRecognitionResultExtractor extends BlinkIdExtractor<HongKongIdFrontRecognizer.Result, HongKongIdFrontRecognizer> {

    @Override
    protected void extractData(HongKongIdFrontRecognizer.Result result) {
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPFullName, result.getFullName());
        add(R.string.PPLocalizedName, result.getLocalizedName());
        add(R.string.PPCommercialCode, result.getCommercialCode());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPResidentialStatus, result.getResidentialStatus());

        Date birthDate = result.getDateOfBirth();
        if (birthDate != null) {
            add(R.string.PPDateOfBirth, birthDate);
        }

        Date dateOfIssue = result.getDateOfIssue();
        if (dateOfIssue != null) {
            add(R.string.PPIssueDate, dateOfIssue);
        }
    }

}
