package com.microblink.blinkid.result.extract.adapters.blinkid;

import com.microblink.blinkid.results.date.SimpleDate;

public class BlinkIDSimpleDate implements com.microblink.blinkid.result.extract.adapters.SimpleDate {

    private final SimpleDate mDate;

    public BlinkIDSimpleDate(SimpleDate date) {
        mDate = date;
    }

    @Override
    public int getDay() {
        return mDate.getDay();
    }

    @Override
    public int getMonth() {
        return mDate.getMonth();
    }

    @Override
    public int getYear() {
        return mDate.getYear();
    }
}
