package com.microblink.blinkid.result.activity;

import android.content.Intent;
import android.os.Bundle;

import com.microblink.blinkid.entities.recognizers.blinkinput.documentcapture.DocumentCaptureRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkinput.documentcapture.DocumentCaptureRecognizerTransferable;
import com.microblink.blinkid.image.highres.HighResImageWrapper;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.activity.fragment.DocumentCaptureResultFragment;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class DocumentCaptureResultActivity extends BaseResultActivity implements
        DocumentCaptureResultFragment.ResultFragmentActivity {

    protected DocumentCaptureRecognizerTransferable documentCaptureRecognizerTransferable;

    @CallSuper
    @Override
    protected void onResume() {
        super.onResume();
        // clear saved state to be sure that data is cleared from cache and from file when
        // intent optimisation is used
        if (documentCaptureRecognizerTransferable != null) {
            documentCaptureRecognizerTransferable.clearSavedState();
        }
    }

    @CallSuper
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (documentCaptureRecognizerTransferable != null) {
            documentCaptureRecognizerTransferable.saveState();

        }
    }

    @NonNull
    @Override
    protected FragmentPagerAdapter createResultFragmentPagerAdapter(Intent intent) {
        documentCaptureRecognizerTransferable = DocumentCaptureRecognizerTransferable.createFromIntent(intent);
        return new DocumentCaptureFragmentAdapter(getSupportFragmentManager());
    }

    @NonNull
    @Override
    public DocumentCaptureRecognizer getRecognizer() {
        return documentCaptureRecognizerTransferable.getDocumentCaptureRecognizer();
    }

    @Nullable
    @Override
    public HighResImageWrapper getCapturedImage() {
        return documentCaptureRecognizerTransferable.getCapturedFullImage();
    }

    private class DocumentCaptureFragmentAdapter extends FragmentPagerAdapter {

        DocumentCaptureFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return DocumentCaptureResultFragment.newInstance();
        }

        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return getString(R.string.MBDocumentCaptureTitle);
        }
    }
}
