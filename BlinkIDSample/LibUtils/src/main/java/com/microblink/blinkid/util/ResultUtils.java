package com.microblink.blinkid.util;

import com.microblink.blinkid.entities.recognizers.successframe.SuccessFrameGrabberRecognizer;
import com.microblink.blinkid.result.extract.adapters.Recognizer;

public class ResultUtils {

    public static CharSequence getEntitySimpleName(Recognizer<?, ?> entity) {
        if (entity.getRecognizer() instanceof SuccessFrameGrabberRecognizer) {
            return ((SuccessFrameGrabberRecognizer) entity.getRecognizer()).getSlaveRecognizer().getClass().getSimpleName();
        } else {
            return entity.getClass().getSimpleName();
        }
    }
}
