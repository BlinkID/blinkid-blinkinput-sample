package com.microblink.blinkid.result.extract.blinkidcustom.switzerland;

import com.microblink.blinkid.entities.recognizers.blinkid.switzerland.SwitzerlandIdBackRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class SwissIDBackSideRecognitionResultExtractor extends BlinkIdExtractor<SwitzerlandIdBackRecognizer.Result, SwitzerlandIdBackRecognizer> {

    @Override
    protected void extractData(SwitzerlandIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());

        add(R.string.PPPlaceOfOrigin, result.getPlaceOfOrigin());
        String authority = result.getAuthority();
        if (!authority.isEmpty()) {
            add(R.string.PPAuthority, authority);
        }
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPHeight, result.getHeight());
    }
}
