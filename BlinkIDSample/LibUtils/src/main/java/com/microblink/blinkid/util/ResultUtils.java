package com.microblink.blinkid.util;

import com.microblink.blinkid.entities.Entity;
import com.microblink.blinkid.entities.recognizers.successframe.SuccessFrameGrabberRecognizer;

public class ResultUtils {

    public static CharSequence getEntitySimpleName(Entity<?> entity) {
        if (entity instanceof SuccessFrameGrabberRecognizer) {
            return getEntitySimpleName(((SuccessFrameGrabberRecognizer) entity).getSlaveRecognizer());
        } else {
            return entity.getClass().getSimpleName();
        }
    }
}
