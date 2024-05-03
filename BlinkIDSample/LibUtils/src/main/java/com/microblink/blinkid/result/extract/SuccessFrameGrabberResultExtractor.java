package com.microblink.blinkid.result.extract;

import com.microblink.blinkid.result.extract.adapters.Recognizer;
import com.microblink.blinkid.entities.recognizers.successframe.SuccessFrameGrabberRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.ResultSource;
import com.microblink.blinkid.result.extract.adapters.blinkid.BlinkIDImage;
import com.microblink.blinkid.result.extract.adapters.blinkid.BlinkIDRecognizer;

public class SuccessFrameGrabberResultExtractor extends BaseResultExtractor<
        SuccessFrameGrabberRecognizer.Result,
        SuccessFrameGrabberRecognizer,
        BlinkIDRecognizer<SuccessFrameGrabberRecognizer.Result, SuccessFrameGrabberRecognizer>
        > {

    @Override
    protected void extractData(SuccessFrameGrabberRecognizer.Result result) {
        BlinkIDRecognizer<?, ?> slaveRecognizer = new BlinkIDRecognizer<>(mRecognizer.getRecognizer().getSlaveRecognizer());
        BaseResultExtractor slaveExtractor = ResultExtractorFactoryProvider.get().createExtractor(slaveRecognizer);
        mExtractedData.addAll(slaveExtractor.extractData(mContext, slaveRecognizer, ResultSource.MIXED));
        mExtractedData.add(mBuilder.build(
                R.string.PPSuccessFrame,
                new BlinkIDImage(mRecognizer.getRecognizer().getResult().getSuccessFrame())
        ));
    }
}
