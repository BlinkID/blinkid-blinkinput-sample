package com.microblink.blinkid.result.extract.adapters.blinkid;

import android.graphics.Bitmap;

import com.microblink.blinkid.image.Image;
import com.microblink.blinkid.result.extract.adapters.Orientation;

public final class BlinkIDImage implements com.microblink.blinkid.result.extract.adapters.Image {

    private final Image mImage;

    public BlinkIDImage(Image image) {
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
