package com.microblink.libutils.result.extract.adapters.blinkinput;

import com.microblink.libutils.result.extract.adapters.SimpleDate;
import com.microblink.blinkinput.results.date.Date;

public final class BlinkInputDate implements com.microblink.libutils.result.extract.adapters.Date {

    private final Date mDate;

    public BlinkInputDate(Date date) {
        mDate = date;
    }

    @Override
    public SimpleDate getDate() {
        return new BlinkInputSimpleDate(mDate.getDate());
    }

    @Override
    public boolean isFilledByDomainKnowledge() {
        return mDate.isFilledByDomainKnowledge();
    }

    @Override
    public String getOriginalDateString() {
        return mDate.getOriginalDateString();
    }
}
