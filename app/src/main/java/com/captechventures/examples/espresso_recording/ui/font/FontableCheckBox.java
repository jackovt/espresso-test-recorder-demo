package com.captechventures.examples.espresso_recording.ui.font;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;

/**
 * Created by thug530 (Jack Hughes) on 7/25/16.
 */
public class FontableCheckBox extends AppCompatCheckBox {

    public FontableCheckBox(Context context) {
        super(context);
    }

    public FontableCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }

    public FontableCheckBox(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }
}