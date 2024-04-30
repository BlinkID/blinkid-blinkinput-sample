package com.microblink.blinkid.result.extract.blinkcard;

import com.microblink.blinkid.entities.recognizers.blinkcard.legacy.LegacyBlinkCardRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.BaseResultExtractor;
import com.microblink.blinkid.result.extract.util.images.CombinedFullDocumentImagesExtractUtil;

public class LegacyBlinkCardRecognitionResultExtractor extends BaseResultExtractor<LegacyBlinkCardRecognizer.Result, LegacyBlinkCardRecognizer> {

    @Override
    protected void extractData(LegacyBlinkCardRecognizer.Result result) {
        add(R.string.PPIssuer, result.getIssuer().name());
        add(R.string.PPPaymentCardNumber, result.getCardNumber());
        addIfNotEmpty(R.string.PPOwner, result.getOwner());
        add(R.string.PPValidThru, result.getValidThru().getOriginalDateString());
        add(R.string.PPCVV, result.getCvv());
        add(R.string.PPIBAN, result.getIban());
        add(R.string.PPInventoryNumber, result.getInventoryNumber());
        CombinedFullDocumentImagesExtractUtil.extractCombinedFullDocumentImages(result, mExtractedData, mBuilder);
    }


}
