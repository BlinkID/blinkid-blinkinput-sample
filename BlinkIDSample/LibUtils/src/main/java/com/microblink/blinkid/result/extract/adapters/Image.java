package com.microblink.blinkid.result.extract.adapters;

import android.graphics.Bitmap;

public interface Image {

    Bitmap convertToBitmap();

    Orientation getImageOrientation();
}
