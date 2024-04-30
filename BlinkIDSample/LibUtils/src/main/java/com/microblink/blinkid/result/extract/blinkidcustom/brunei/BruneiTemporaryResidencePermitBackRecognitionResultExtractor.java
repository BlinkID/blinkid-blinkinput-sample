package com.microblink.blinkid.result.extract.blinkidcustom.brunei;
import com.microblink.blinkid.entities.recognizers.blinkid.brunei.BruneiTemporaryResidencePermitBackRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class BruneiTemporaryResidencePermitBackRecognitionResultExtractor extends BlinkIdExtractor<BruneiTemporaryResidencePermitBackRecognizer.Result, BruneiTemporaryResidencePermitBackRecognizer> {

        @Override
        protected void extractData(BruneiTemporaryResidencePermitBackRecognizer.Result result) {
            extractMRZResult(result.getMrzResult());

            add(R.string.PPPassportNumber, result.getPassportNumber());
            add(R.string.PPAddress, result.getAddress());
            add(R.string.PPIssueDate, result.getDateOfIssue());
        }

}
