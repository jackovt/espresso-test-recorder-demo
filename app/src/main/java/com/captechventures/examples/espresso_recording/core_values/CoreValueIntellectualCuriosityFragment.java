package com.captechventures.examples.espresso_recording.core_values;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.captechventures.examples.espresso_recording.R;

import butterknife.ButterKnife;

/**
 * Created by thug530 (Jack Hughes) on 8/15/16.
 */
public class CoreValueIntellectualCuriosityFragment extends BaseCoreValueFragment {

    public static CoreValueIntellectualCuriosityFragment newInstance() {
        return new CoreValueIntellectualCuriosityFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_intellectual_curiosity, container, false);

        ButterKnife.bind(this, fragmentView);
        // If this is the first creation, default state
        if (savedInstanceState == null) {

        }
        return fragmentView;
    }

}