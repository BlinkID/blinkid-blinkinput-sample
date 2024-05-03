package com.microblink.libutils.result.extract.adapters;

import android.graphics.Bitmap;

public interface Image {

    Bitmap convertToBitmap();

    Orientation getImageOrientation();
}
