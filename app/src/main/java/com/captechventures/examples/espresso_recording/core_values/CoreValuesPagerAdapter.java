package com.captechventures.examples.espresso_recording.core_values;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.captechventures.examples.espresso_recording.core_values.CoreValueEnthusiasmFragment;
import com.captechventures.examples.espresso_recording.core_values.CoreValueFlexibilityFragment;
import com.captechventures.examples.espresso_recording.core_values.CoreValueIntellectualCuriosityFragment;
import com.captechventures.examples.espresso_recording.core_values.CoreValueServantLeadershipFragment;
import com.captechventures.examples.espresso_recording.core_values.CoreValueTrustedAdvisorFragment;

/**
 * Created by thug530 (Jack Hughes) on 8/15/16.
 */

public class CoreValuesPagerAdapter extends FragmentPagerAdapter {

    public CoreValuesPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return CoreValueTrustedAdvisorFragment.newInstance();
            case 1:
                return CoreValueIntellectualCuriosityFragment.newInstance();
            case 2:
                return CoreValueFlexibilityFragment.newInstance();
            case 3:
                return CoreValueEnthusiasmFragment.newInstance();
            case 4:
                return CoreValueServantLeadershipFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
