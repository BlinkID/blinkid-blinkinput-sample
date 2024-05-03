package com.microblink.libutils.result.extract.adapters.blinkinput;


import com.microblink.blinkinput.results.date.SimpleDate;

public final class BlinkInputSimpleDate implements com.microblink.libutils.result.extract.adapters.SimpleDate {

    private final SimpleDate mDate;

    BlinkInputSimpleDate(SimpleDate date) {
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
