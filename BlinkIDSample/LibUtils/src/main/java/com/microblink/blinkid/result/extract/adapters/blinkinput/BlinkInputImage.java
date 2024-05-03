package com.microblink.blinkid.result.extract.adapters.blinkinput;

import android.graphics.Bitmap;

import com.microblink.blinkid.result.extract.adapters.Orientation;
import com.microblink.blinkinput.image.Image;

public final class BlinkInputImage implements com.microblink.blinkid.result.extract.adapters.Image {

    private final Image mImage;

    public BlinkInputImage(Image image) {
        mImage = image;
    }

    @Override
    public Bitmap convertToBitmap() {
        return mImage != null ? mImage.convertToBitmap() : null;
    }

    @Override
    public Orientation getImageOrientation() {
        if (mImage != null) {
            return Orientation.values()[mImage.getImageOrientation().ordinal()];
        } else {
            return Orientation.ORIENTATION_UNKNOWN;
        }
    }
}
