package com.microblink.blinkid.result.extract.blinkcard;

import com.microblink.blinkid.entities.recognizers.blinkcard.legacy.LegacyBlinkCardEliteRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.BaseResultExtractor;
import com.microblink.blinkid.result.extract.util.images.CombinedFullDocumentImagesExtractUtil;

public class LegacyBlinkCardEliteRecognitionResultExtractor extends BaseResultExtractor<LegacyBlinkCardEliteRecognizer.Result, LegacyBlinkCardEliteRecognizer> {
    @Override
    protected void extractData(LegacyBlinkCardEliteRecognizer.Result result) {
        add(R.string.PPPaymentCardNumber, result.getCardNumber());
        add(R.string.PPOwner, result.getOwner());
        add(R.string.PPValidThru, result.getValidThru());
        add(R.string.PPCVV, result.getCvv());
        add(R.string.PPInventoryNumber, result.getInventoryNumber());
        CombinedFullDocumentImagesExtractUtil.extractCombinedFullDocumentImages(result, mExtractedData, mBuilder);
    }
}
