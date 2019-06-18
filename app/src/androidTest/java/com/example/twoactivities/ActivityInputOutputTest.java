package com.example.twoactivities;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ActivityInputOutputTest {
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule(MainActivity.class);
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.twoactivities", appContext.getPackageName());
    }
    @Test
    public void activityLaunch(){
        Espresso.onView(ViewMatchers.withId(R.id.button_main)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button_second)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.text_header_reply)).check(ViewAssertions.matches(isDisplayed()));
    }
    @Test
    public void textInputOutput(){
        Espresso.onView(withId(R.id.editText_main)).perform(typeText("This is a test."));
        Espresso.onView(withId(R.id.button_main)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.text_message)).check(ViewAssertions.matches(withText("This is a test.")));
    }
}
