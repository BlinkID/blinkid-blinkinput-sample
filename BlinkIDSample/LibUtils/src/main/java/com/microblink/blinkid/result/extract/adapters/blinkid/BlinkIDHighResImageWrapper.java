package com.microblink.blinkid.result.extract.adapters.blinkid;

import com.microblink.blinkid.image.highres.HighResImageWrapper;
import com.microblink.blinkid.result.extract.adapters.Image;

import java.io.File;
import java.io.IOException;

public final class BlinkIDHighResImageWrapper implements com.microblink.blinkid.result.extract.adapters.HighResImageWrapper {

    private final HighResImageWrapper mWrapper;

    public BlinkIDHighResImageWrapper(HighResImageWrapper wrapper) {
        mWrapper = wrapper;
    }

    @Override
    public Image getImage() {
        return new BlinkIDImage(mWrapper.getImage());
    }

    @Override
    public void saveToFile(File file) throws IOException {
        mWrapper.saveToFile(file);
    }
}
