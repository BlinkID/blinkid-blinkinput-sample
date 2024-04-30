package com.microblink.blinkid.result.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import android.view.View;

import com.microblink.blinkid.entities.parsers.config.fieldbyfield.FieldByFieldBundle;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.activity.fragment.FieldByFieldResultFragment;

public class FieldByFieldResultActivity extends BaseResultActivity implements
        FieldByFieldResultFragment.FieldByFieldResultFragmentActivity {

    protected FieldByFieldBundle mFieldByFieldBundle;

    @Override
    protected void onResume() {
        super.onResume();
        // clear saved state to be sure that data is cleared from cache and from file when
        // intent optimisation is used
        mFieldByFieldBundle.clearSavedState();
    }

    @Override
    protected FragmentPagerAdapter createResultFragmentPagerAdapter(Intent intent) {
        mFieldByFieldBundle = new FieldByFieldBundle();
        mFieldByFieldBundle.loadFromIntent(intent);
        return new FieldByFieldBundleFragmentAdapter(getSupportFragmentManager());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mFieldByFieldBundle.saveState();
    }

    @Override
    public FieldByFieldBundle getFieldByFieldBundle() {
        return mFieldByFieldBundle;
    }

    private class FieldByFieldBundleFragmentAdapter extends FragmentPagerAdapter {

        FieldByFieldBundleFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return FieldByFieldResultFragment.newInstance();
        }

        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return FieldByFieldResultActivity.this.getString(R.string.title_field_by_field_results);
        }

    }
}
