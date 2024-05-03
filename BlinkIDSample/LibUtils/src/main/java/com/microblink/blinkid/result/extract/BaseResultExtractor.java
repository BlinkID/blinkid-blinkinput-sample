package com.microblink.blinkid.result.extract;

import com.microblink.blinkid.result.ResultSource;
import com.microblink.blinkid.result.extract.adapters.Date;
import com.microblink.blinkid.result.extract.adapters.Image;
import com.microblink.blinkid.result.extract.adapters.Recognizer;
import com.microblink.blinkid.result.extract.adapters.SimpleDate;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseResultExtractor<ResultType, RecognizerType, AdapterRecognizerType extends Recognizer<ResultType, RecognizerType>> {

    protected RecognitionResultEntry.Builder mBuilder;
    protected List<RecognitionResultEntry> mExtractedData;
    protected AdapterRecognizerType mRecognizer;
    protected Context mContext;

    public List<RecognitionResultEntry> extractData(Context context, AdapterRecognizerType recognizer, ResultSource resultSource) {
        mContext = context;
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
        mRecognizer = recognizer;

        ResultType result = recognizer.getResult();
        extractData(result, resultSource);
        onDataExtractionDone(result, resultSource);

        return mExtractedData;
    }

    // override if needed
    public boolean doesSupportResultSourceExtraction() {
        return false;
    }

    // override if needed
    protected void onDataExtractionDone(ResultType result) {}
    protected void onDataExtractionDone(ResultType result, ResultSource resultSource) {
        onDataExtractionDone(result);
    }

    protected abstract void extractData(ResultType result);
    protected void extractData(ResultType result, ResultSource resultSource) {
        extractData(result);
    }
    protected void extractData(ResultType result, ResultSource resultSource, String jsonResult) {
        extractData(result);
    }

    protected void add(int key, String value) {
        mExtractedData.add(mBuilder.build(key, value));
    }

    protected void addIfNotEmpty(int key, String value) {
        if (!value.isEmpty()) {
            mExtractedData.add(mBuilder.build(key, value));
        }
    }

    protected void add(int key, int value, String valueSuffix) {
        mExtractedData.add(mBuilder.build(key, value, valueSuffix));
    }

    protected void add(int key, Date date) {
        mExtractedData.add(mBuilder.build(key, date != null ? date.getDate() : null, date != null && date.isFilledByDomainKnowledge()));
    }

    protected void addIfNotEmpty(int key, Date dateResult) {
        if (dateResult == null) return;
        SimpleDate date = dateResult.getDate();
        if (date != null) {
            add(key, dateResult);
        } else {
            addIfNotEmpty(key, dateResult.getOriginalDateString());
        }
    }

    protected void add(int key, SimpleDate date, boolean isFilledByDomainKnowledge) {
        mExtractedData.add(mBuilder.build(key, date, isFilledByDomainKnowledge));
    }

    protected void add(int key, boolean value) {
        mExtractedData.add(mBuilder.build(key, value));
    }

    protected void add(int key, int value) {
        mExtractedData.add(mBuilder.build(key, value));
    }

    protected void add(int key, byte[] value) {
        mExtractedData.add(mBuilder.build(key, value));
    }

    protected void add(int key, Image image) {
        mExtractedData.add(mBuilder.build(key, image));
    }

    protected void add(int key, Bitmap bitmap) {
        mExtractedData.add(mBuilder.build(key, bitmap));
    }


}
