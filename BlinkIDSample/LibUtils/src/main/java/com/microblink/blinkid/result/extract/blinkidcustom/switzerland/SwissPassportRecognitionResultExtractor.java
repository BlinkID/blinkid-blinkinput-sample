package com.microblink.blinkid.result.extract.blinkidcustom.switzerland;

import com.microblink.blinkid.entities.recognizers.blinkid.switzerland.SwitzerlandPassportRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class SwissPassportRecognitionResultExtractor extends BlinkIdExtractor<SwitzerlandPassportRecognizer.Result, SwitzerlandPassportRecognizer> {

    @Override
    protected void extractData(SwitzerlandPassportRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());

        String name = result.getGivenName();
        if (!name.isEmpty()) {
            add(R.string.PPFirstName, name);
        }
        String surname = result.getSurname();
        if (!surname.isEmpty()) {
            add(R.string.PPLastName, surname);
        }
        add(R.string.PPPlaceOfOrigin, result.getPlaceOfOrigin());
        String authority = result.getAuthority();
        if (!authority.isEmpty()) {
            add(R.string.PPAuthority, authority);
        }
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPPassportNumber, result.getPassportNumber());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPHeight, result.getHeight());
    }
}
