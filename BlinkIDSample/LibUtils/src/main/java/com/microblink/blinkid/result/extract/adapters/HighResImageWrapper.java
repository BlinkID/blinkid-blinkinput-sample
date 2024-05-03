package com.microblink.blinkid.result.extract.adapters;

import java.io.File;
import java.io.IOException;

public interface HighResImageWrapper {

    Image getImage();

    void saveToFile(File file) throws IOException;
}
