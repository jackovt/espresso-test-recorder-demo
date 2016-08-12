package com.captechventures.examples.espresso_recording;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.captechventures.examples.espresso_recording.core_values.CoreValuesActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_colors)
    public void colorsClicked(View view) {
        Intent intentColors = new Intent(MainActivity.this, ColorsActivity.class);
        startActivity(intentColors);
    }

    @OnClick(R.id.bt_core_values)
    public void coreValuesClicked(View view) {
        Intent intentCoreValues = new Intent(MainActivity.this, CoreValuesActivity.class);
        startActivity(intentCoreValues);
    }

    @OnClick(R.id.bt_components)
    public void componentsClicked(View view) {
        Intent intentComponents = new Intent(MainActivity.this, ComponentsActivity.class);
        startActivity(intentComponents);
    }

    @OnClick(R.id.bt_assets)
    public void assetsClicked(View view) {
        Intent intentAssets = new Intent(MainActivity.this, AssetsActivity.class);
        startActivity(intentAssets);
    }
}
