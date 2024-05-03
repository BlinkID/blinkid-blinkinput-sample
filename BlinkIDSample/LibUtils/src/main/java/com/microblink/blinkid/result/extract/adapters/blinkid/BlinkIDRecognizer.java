package com.microblink.blinkid.result.extract.adapters.blinkid;

import com.microblink.blinkid.result.extract.adapters.Recognizer;

public final class BlinkIDRecognizer<
        ResultType extends com.microblink.blinkid.entities.recognizers.Recognizer.Result,
        RecognizerType extends com.microblink.blinkid.entities.recognizers.Recognizer<ResultType>
        > implements Recognizer<ResultType, RecognizerType> {

    private final RecognizerType mRecognizer;

    public BlinkIDRecognizer(RecognizerType recognizer) {
        mRecognizer = recognizer;
    }

    @Override
    public ResultType getResult() {
        return mRecognizer.getResult();
    }

    @Override
    public RecognizerType getRecognizer() {
        return mRecognizer;
    }
}
