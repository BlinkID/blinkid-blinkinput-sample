package com.microblink.blinkid.result.extract.adapters;

public interface Recognizer<ResultType, ConcreteRecognizer> {

    ResultType getResult();

    ConcreteRecognizer getRecognizer();
}
