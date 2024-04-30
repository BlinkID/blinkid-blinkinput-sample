package com.microblink.blinkid.result.extract.blinkinput;

import com.microblink.blinkinput.entities.recognizers.Recognizer;
import com.microblink.blinkinput.entities.recognizers.blinkinput.documentcapture.DocumentCaptureRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.BaseResultExtractor;

public class DocumentCaptureResultExtractor extends BaseResultExtractor<DocumentCaptureRecognizer.Result, DocumentCaptureRecognizer> {
    @Override
    protected void extractData(DocumentCaptureRecognizer.Result result) {
        add(R.string.MBRecognitionStatus, result.getResultState().name());
        if (result.getResultState() != Recognizer.Result.State.Empty) {
            mExtractedData.add(mBuilder.build(R.string.MBFullDocumentImage, result.getFullDocumentImage()));
            mExtractedData.add(mBuilder.build(R.string.MBEncodedFullDocumentImage, result.getEncodedFullDocumentImage()));
            add(R.string.MBDocumentLocation, result.getDetectionLocation().toString());
        }
    }
}
