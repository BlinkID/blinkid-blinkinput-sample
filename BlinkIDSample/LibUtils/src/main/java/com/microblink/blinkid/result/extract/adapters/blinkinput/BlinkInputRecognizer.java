package com.microblink.blinkid.result.extract.adapters.blinkinput;

import com.microblink.blinkid.result.extract.adapters.Recognizer;

public class BlinkInputRecognizer<
        ResultType extends com.microblink.blinkinput.entities.recognizers.Recognizer.Result,
        RecognizerType extends com.microblink.blinkinput.entities.recognizers.Recognizer<ResultType>
        > implements Recognizer<ResultType, RecognizerType> {

    private final RecognizerType mRecognizer;

    public BlinkInputRecognizer(RecognizerType recognizer) {
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
