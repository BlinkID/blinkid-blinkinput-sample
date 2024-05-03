package com.microblink.blinkid.result.extract.adapters.blinkinput;

import com.microblink.blinkid.result.extract.adapters.Image;
import com.microblink.blinkinput.image.highres.HighResImageWrapper;

import java.io.File;
import java.io.IOException;

public final class BlinkInputHighResImageWrapper implements com.microblink.blinkid.result.extract.adapters.HighResImageWrapper {

    private final HighResImageWrapper mWrapper;

    public BlinkInputHighResImageWrapper(HighResImageWrapper wrapper) {
        mWrapper = wrapper;
    }

    @Override
    public Image getImage() {
        return new BlinkInputImage(mWrapper.getImage());
    }

    @Override
    public void saveToFile(File file) throws IOException {
        mWrapper.saveToFile(file);
    }
}
