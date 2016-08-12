package com.captechventures.examples.espresso_recording;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ColorsActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void colorsActivityErrorHandlingTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.bt_colors), withText("Colors"),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton.perform(click());

        onView(allOf(withId(R.id.snackbar_text), withText("Please select a color"),
                isDisplayed())).check(matches(isDisplayed()));

    }

    @Test
    public void colorsActivityTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.bt_colors), withText("Colors"),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction cardView = onView(
                allOf(withId(R.id.cv_secondary_blue),
                        withParent(withId(R.id.ll_color_cards)),
                        isDisplayed()));
        cardView.perform(click());

        onView(allOf(withId(R.id.snackbar_text), withText("Selected Blue with Hex of #ff00a1e0"),
                isDisplayed())).check(matches(isDisplayed()));

    }

    @Test
    public void colorsActivityCopyPastingTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.bt_colors), withText("Colors"),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction cardView = onView(
                allOf(withId(R.id.cv_secondary_blue),
                        withParent(withId(R.id.ll_color_cards)),
                        isDisplayed()));
        cardView.perform(click());

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton.perform(click());

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.snackbar_action), withText("Copy Hex Value"), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.et_color_edit_text),
                        withParent(withId(R.id.ll_color_cards)),
                        isDisplayed()));
        appCompatEditText.perform(longClick());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.et_color_edit_text),
                        withParent(withId(R.id.ll_color_cards)),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("#ff00a1e0"));

        ViewInteraction editText = onView(
                allOf(withId(R.id.et_color_edit_text), withText("#ff00a1e0"),
                        withParent(withId(R.id.ll_color_cards)),
                        isDisplayed()));
        editText.check(matches(withText("#ff00a1e0")));

    }
}
