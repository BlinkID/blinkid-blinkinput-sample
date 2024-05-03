package com.microblink.libutils.result.extract.adapters;

public interface Recognizer<ResultType, ConcreteRecognizer> {

    ResultType getResult();

    ConcreteRecognizer getRecognizer();
}
