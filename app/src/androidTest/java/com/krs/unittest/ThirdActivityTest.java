package com.krs.unittest;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class ThirdActivityTest {

    @Rule
    public ActivityTestRule<ThirdActivity> thirdActivity=new ActivityTestRule<>(ThirdActivity.class);

    private String nName="Tony";

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void TestScenario()
    {
        //input some text in edittext
        Espresso.onView(withId(R.id.edtText)).perform(typeText(nName));
        //close soft keyboard
        Espresso.closeSoftKeyboard();
        //perform button click
        Espresso.onView(withId(R.id.btnClick)).perform(click());
        //checking the text in textview
        Espresso.onView(withId(R.id.txtView)).check(matches(withText(nName)));
    }

    @After
    public void tearDown() throws Exception {
    }
}