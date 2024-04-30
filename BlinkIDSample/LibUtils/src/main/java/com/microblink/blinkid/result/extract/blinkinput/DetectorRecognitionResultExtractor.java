package com.microblink.blinkid.result.extract.blinkinput;

import com.microblink.blinkid.entities.recognizers.detector.DetectorRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.BaseResultExtractor;

public class DetectorRecognitionResultExtractor extends BaseResultExtractor<DetectorRecognizer.Result, DetectorRecognizer> {

    @Override
    protected void extractData(DetectorRecognizer.Result result) {
        add(R.string.MBRecognitionStatus, result.getResultState().name());
        // add detection location
        add(R.string.PPDetectorResult, mRecognizer.getDetector().getResult().toString());

        TemplateDataExtractor templateDataExtractor = new TemplateDataExtractor();
        mExtractedData.addAll(templateDataExtractor.extract(mContext, mRecognizer));
    }

}
