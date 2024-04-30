package com.microblink.blinkid.result.extract.blinkidcustom.brunei;
import com.microblink.blinkid.entities.recognizers.blinkid.brunei.BruneiIdBackRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class BruneiIdBackRecognitionResultExtractor extends BlinkIdExtractor<BruneiIdBackRecognizer.Result, BruneiIdBackRecognizer> {

        @Override
        protected void extractData(BruneiIdBackRecognizer.Result result) {
            extractMRZResult(result.getMrzResult());

            add(R.string.PPRace, result.getRace());
            add(R.string.PPAddress, result.getAddress());
            add(R.string.PPIssueDate, result.getDateOfIssue());
        }

}
