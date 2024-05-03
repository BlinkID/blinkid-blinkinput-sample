package com.microblink.blinkid.result.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.microblink.blinkid.result.activity.fragment.ResultFragment;
import com.microblink.blinkid.result.extract.adapters.Recognizer;
import com.microblink.blinkid.result.extract.adapters.blinkid.BlinkIDRecognizer;
import com.microblink.blinkid.result.extract.adapters.blinkinput.BlinkInputRecognizer;
import com.microblink.blinkid.util.ResultUtils;

import java.util.ArrayList;
import java.util.List;

public class RecognizerBundleResultActivity extends BaseResultActivity implements
        ResultFragment.ResultFragmentActivity {

    private static final String SHOULD_SHOW_RESULT_DIALOG_EXTRA = "SHOULD_SHOW_RESULT_DIALOG_EXTRA";

    protected com.microblink.blinkid.entities.recognizers.RecognizerBundle mBlinkIdRecognizerBundle;
    protected com.microblink.blinkinput.entities.recognizers.RecognizerBundle mBlinkInputRecognizerBundle;
    private List<Recognizer<?, ?>> mRecognizersWithResult;

    public static void putShouldShowResultDialogExtra(Intent data, boolean shouldShowResultDialog) {
        data.putExtra(SHOULD_SHOW_RESULT_DIALOG_EXTRA, shouldShowResultDialog);
    }

    private static boolean getShouldShowResultDialogExtra(Intent data) {
        return data.getBooleanExtra(SHOULD_SHOW_RESULT_DIALOG_EXTRA, false);
    }

    @CallSuper
    @Override
    protected void onResume() {
        super.onResume();
        // clear saved state to be sure that data is cleared from cache and from file when
        // intent optimisation is used
        if (mBlinkIdRecognizerBundle != null) {
            mBlinkIdRecognizerBundle.clearSavedState();
        }
    }

    @NonNull
    @Override
    protected FragmentPagerAdapter createResultFragmentPagerAdapter(Intent intent) {
        mRecognizersWithResult = obtainRecognizersWithResult(intent);
        return new RecognizerListFragmentAdapter(getSupportFragmentManager());
    }

    protected List<Recognizer<?, ?>> obtainRecognizersWithResult(Intent intent) {
        StringBuilder resultDialogMessageBuilder = new StringBuilder();

        List<Recognizer<?, ?>> recognizersWithResult = new ArrayList<>();
        try {
            mBlinkIdRecognizerBundle = new com.microblink.blinkid.entities.recognizers.RecognizerBundle();
            mBlinkIdRecognizerBundle.loadFromIntent(intent);

            for (com.microblink.blinkid.entities.recognizers.Recognizer<com.microblink.blinkid.entities.recognizers.Recognizer.Result> r : mBlinkIdRecognizerBundle.getRecognizers()) {
                if (r.getResult().getResultState() != com.microblink.blinkid.entities.recognizers.Recognizer.Result.State.Empty) {
                    recognizersWithResult.add(new BlinkIDRecognizer<>(r));
                }

                resultDialogMessageBuilder.append(String.format("%s: %s\n",
                        r.getName(),
                        r.getResult().getResultState().name()));
            }
        } catch (IllegalStateException exc) {
            // ignore - BlinkID results not existing
        }

        try {
            mBlinkInputRecognizerBundle = new com.microblink.blinkinput.entities.recognizers.RecognizerBundle();
            mBlinkInputRecognizerBundle.loadFromIntent(intent);

            for (com.microblink.blinkinput.entities.recognizers.Recognizer<com.microblink.blinkinput.entities.recognizers.Recognizer.Result> r : mBlinkInputRecognizerBundle.getRecognizers()) {
                if (r.getResult().getResultState() != com.microblink.blinkinput.entities.recognizers.Recognizer.Result.State.Empty) {
                    recognizersWithResult.add(new BlinkInputRecognizer<>(r));
                }

                resultDialogMessageBuilder.append(String.format("%s: %s\n",
                        r.getName(),
                        r.getResult().getResultState().name()));
            }
        } catch (IllegalStateException exc) {
            // ignore = BlinkInput results not existing
        }

        showResultDialogIfEligible(resultDialogMessageBuilder.toString());

        return recognizersWithResult;
    }

    private void showResultDialogIfEligible(String resultDialogMessage) {
        boolean shouldShowResultDialog = getShouldShowResultDialogExtra(getIntent());

        if (shouldShowResultDialog) {
            new AlertDialog.Builder(this)
                    .setTitle("Recognizer Result States")
                    .setMessage(resultDialogMessage)
                    .setPositiveButton("OK", null)
                    .create()
                    .show();
        }
    }

    @CallSuper
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mBlinkIdRecognizerBundle != null) {
            mBlinkIdRecognizerBundle.saveState();

        }
    }

    @Override
    public Recognizer getRecognizerAtPosition(int resultPosition) {
        if (resultPosition < 0 || resultPosition >= mRecognizersWithResult.size()) {
            throw new IllegalStateException("Recognizer with non empty result on requested position"
                    + " does not exist. Possible cause is that recognizer bundle state has been lost"
                    + " in intent transactions.");
        }
        //noinspection unchecked
        return mRecognizersWithResult.get(resultPosition);
    }

    private class RecognizerListFragmentAdapter extends FragmentPagerAdapter {

        RecognizerListFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ResultFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return mRecognizersWithResult.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return ResultUtils.getEntitySimpleName(mRecognizersWithResult.get(position));
        }
    }

}
