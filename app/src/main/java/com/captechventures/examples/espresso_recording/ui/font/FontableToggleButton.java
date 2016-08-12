package com.captechventures.examples.espresso_recording.ui.font;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/**
 * Created by thug530 (Jack Hughes) on 7/25/16.
 */
public class FontableToggleButton extends ToggleButton {

    public FontableToggleButton(Context context) {
        super(context);
    }

    public FontableToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }

    public FontableToggleButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }
}