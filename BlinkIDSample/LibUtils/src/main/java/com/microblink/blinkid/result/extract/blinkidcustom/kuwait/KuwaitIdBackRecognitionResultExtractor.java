package com.microblink.blinkid.result.extract.blinkidcustom.kuwait;

import com.microblink.blinkid.entities.recognizers.blinkid.kuwait.KuwaitIdBackRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class KuwaitIdBackRecognitionResultExtractor  extends BlinkIdExtractor<KuwaitIdBackRecognizer.Result, KuwaitIdBackRecognizer> {

    @Override
    protected void extractData(KuwaitIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());

        add(R.string.PPSerialNo, result.getSerialNo());
    }
}