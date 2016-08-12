package com.captechventures.examples.espresso_recording.ui.font;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by thug530 (Jack Hughes) on 7/19/16.
 */
public class FontableTextView extends TextView {

    public FontableTextView(Context context) {
        super(context);
    }

    public FontableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }

    public FontableTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }
}