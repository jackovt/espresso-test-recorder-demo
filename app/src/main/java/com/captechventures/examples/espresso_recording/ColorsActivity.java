package com.captechventures.examples.espresso_recording;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ColorsActivity extends AppCompatActivity {

    private ClipboardManager mClipboard;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.ll_color_cards)
    LinearLayout colorCardsLinearLayout;

    private String mColorSelected;

    private String mColorSelectedHex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        mClipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.fab)
    public void fabClicked(View view) {
        String message = getString(R.string.snackbar_message_prompt_color);

        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);

        if (!TextUtils.isEmpty(mColorSelected)) {
            snackbar.setText(mColorSelected);
            snackbar.setAction(R.string.snackbar_action_copy, new OnClickListener() {
                @Override
                public void onClick(View view) {
                    ClipData clip = ClipData.newPlainText("color_hex", mColorSelectedHex);
                    mClipboard.setPrimaryClip(clip);
                    Toast.makeText(ColorsActivity.this, R.string.toast_copied_success, Toast.LENGTH_SHORT).show();
                }
            });
        }

        snackbar.show();
    }

    /**
     * Get the color from the view ID
     *
     * @param viewId
     *         the String name of the view
     * @param makeTitleCase
     *         whether or not to tile case the color
     *
     * @return the color as a String with the first word capitalized
     */
    private String getColorFromCardViewId(String viewId, boolean makeTitleCase) {
        // Get the view id's prefix
        String idPrefix = getCardViewIdPrefix();
        if (!TextUtils.isEmpty(idPrefix) && !TextUtils.isEmpty(viewId)) {
            //remove the prefix from the view ID¬
            String color = viewId.replace(idPrefix, "");
            return makeTitleCase ? (color.substring(0, 1).toUpperCase() + color.substring(1)) : color;
        }
        return null;
    }

    /**
     * Get the view ID of the color view from the view ID of the CardView
     *
     * @param viewId
     *         the String name of the view
     *
     * @return the color as a String with the first word capitalized
     */
    private String getColorHexFromCardViewId(String viewId) {
        // Get the color and the hex color id's prefix
        String color = getColorFromCardViewId(viewId, false);
        String colorIdPrefix = getColorPrefix();
        if (!TextUtils.isEmpty(color) && !TextUtils.isEmpty(colorIdPrefix)) {
            String colorIdName = new StringBuilder(colorIdPrefix).append(color).toString();
            int colorId = getResources().getIdentifier(colorIdName, "color", getPackageName());
            return getResources().getString(colorId);
        }
        return null;
    }

    /**
     * Get the prefix for the CardView by using a known id and removing the know postfix (the
     * color), so that if the id is refactored, this function does not need to change.
     *
     * @return the prefix of the CardView id.
     */
    private String getCardViewIdPrefix() {
        return getResources().getResourceEntryName(R.id.cv_secondary_blue).replace("blue", "");
    }

    /**
     * Get the prefix for the color by using a known id and removing the know postfix (the name of
     * the color), so that if the id is refactored, this function does not need to change.
     *
     * @return the prefix of the color id.
     */
    private String getColorPrefix() {
        return getResources().getResourceEntryName(R.color.secondary_blue).replace("blue", "");
    }

    @OnClick({
            R.id.cv_secondary_blue,
            R.id.cv_secondary_orange,
            R.id.cv_secondary_red,
            R.id.cv_secondary_purple,
            R.id.cv_secondary_teal,
            R.id.cv_secondary_green
    })
    public void cardViewClicked(View view) {
        CardView colorCard = (CardView) view;
        String cardViewId = getResources().getResourceEntryName(colorCard.getId());
        colorCard.requestFocus();
        mColorSelected = getColorFromCardViewId(cardViewId, true);
        mColorSelectedHex = getColorHexFromCardViewId(cardViewId);
        String message = String.format(Locale.getDefault(), getString(R.string.snackbar_message_color_selected), mColorSelected, mColorSelectedHex);
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }
}
