package com.captechventures.examples.espresso_recording.core_values;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Spinner;

import com.captechventures.examples.espresso_recording.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

public class CoreValuesActivity extends AppCompatActivity {

    @BindView(R.id.sp_core_values)
    Spinner mSpinnerCoreValues;

    @BindView(R.id.vp_core_values)
    ViewPager mViewPagerCoreValues;

    private CoreValuesPagerAdapter mCoreValuesPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_values);

        ButterKnife.bind(this);

        mCoreValuesPagerAdapter = new CoreValuesPagerAdapter(getSupportFragmentManager());
        mViewPagerCoreValues.setAdapter(mCoreValuesPagerAdapter);

        mViewPagerCoreValues.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Nothing needed here
            }

            @Override
            public void onPageSelected(int position) {
                mSpinnerCoreValues.setSelection(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // Nothing needed here
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnItemSelected(R.id.sp_core_values)
    public void onCoreValueSelected(Spinner spinner, int position) {
        mViewPagerCoreValues.setCurrentItem(position);
    }

}
