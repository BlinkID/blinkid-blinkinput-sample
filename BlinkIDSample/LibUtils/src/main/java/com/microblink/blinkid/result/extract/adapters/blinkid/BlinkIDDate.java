package com.microblink.blinkid.result.extract.adapters.blinkid;

import com.microblink.blinkid.result.extract.adapters.SimpleDate;
import com.microblink.blinkid.results.date.Date;

public final class BlinkIDDate implements com.microblink.blinkid.result.extract.adapters.Date {

    private final Date mDate;

    public BlinkIDDate(Date date) {
        mDate = date;
    }

    @Override
    public SimpleDate getDate() {
        return new BlinkIDSimpleDate(mDate.getDate());
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
