package com.captechventures.examples.espresso_recording.ui.font;

import android.content.Context;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;

/**
 * Created by thug530 (Jack Hughes) on 7/25/16.
 */
public class FontableSwitch extends SwitchCompat {

    public FontableSwitch(Context context) {
        super(context);
    }

    public FontableSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }

    public FontableSwitch(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }
}