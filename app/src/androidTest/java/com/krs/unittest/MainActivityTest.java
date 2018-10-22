package com.krs.unittest;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainTestRule = new ActivityTestRule<>(MainActivity.class);
    MainActivity mainActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(SecondActivity.class.getName(), null, false);

    @Test
    public void sum() {
        View view = mainActivity.findViewById(R.id.btnPress);
        assertNotNull(view);
        onView(withId(R.id.btnPress)).perform(click());
        Activity second = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(second);
        second.finish();
    }

    @Before
    public void setUp() throws Exception {
        mainActivity = mainTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }

}