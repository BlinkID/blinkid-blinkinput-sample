package com.microblink.libutils.result.extract.adapters;

public interface Date {

    SimpleDate getDate();

    boolean isFilledByDomainKnowledge();

    String getOriginalDateString();
}
