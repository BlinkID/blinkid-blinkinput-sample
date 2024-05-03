package com.microblink.libutils.result.extract;

import com.microblink.blinkid.entities.recognizers.successframe.SuccessFrameGrabberRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.libutils.result.ResultSource;
import com.microblink.libutils.result.extract.adapters.blinkid.BlinkIDImage;
import com.microblink.libutils.result.extract.adapters.blinkid.BlinkIDRecognizer;

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
