package com.captechventures.examples.espresso_recording.core_values;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

import com.captechventures.examples.espresso_recording.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by thug530 (Jack Hughes) on 8/16/16.
 */

public abstract class BaseCoreValueFragment extends Fragment {

    @BindView(R.id.rl_core_values_content)
    RelativeLayout mRelativeLayoutCoreValuesContent;

    @BindView(R.id.bt_toggle_content)
    ToggleButton mToggleButtonContent;

    @Override
    public void onResume() {
        super.onResume();
        if (mToggleButtonContent.isChecked()) {
            mRelativeLayoutCoreValuesContent.setVisibility(View.VISIBLE);
        }
        else {
            mRelativeLayoutCoreValuesContent.setVisibility(View.INVISIBLE);
        }
    }

    @OnClick(R.id.bt_toggle_content)
    public void onClickToggle(ToggleButton button) {
        if (button.isChecked()) {
            mRelativeLayoutCoreValuesContent.setVisibility(View.VISIBLE);
        }
        else {
            mRelativeLayoutCoreValuesContent.setVisibility(View.INVISIBLE);
        }
    }
}
