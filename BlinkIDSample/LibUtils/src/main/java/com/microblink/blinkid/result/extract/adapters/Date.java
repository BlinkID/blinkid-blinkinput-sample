package com.microblink.blinkid.result.extract.adapters;

public interface Date {

    SimpleDate getDate();

    boolean isFilledByDomainKnowledge();

    String getOriginalDateString();
}
