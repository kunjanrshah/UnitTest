package com.krs.unittest;

import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.RelativeLayout;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertNotNull;

public class SecondActivityTest {

    @Rule
    public ActivityTestRule<SecondActivity> mainTestRule = new ActivityTestRule<>(SecondActivity.class);
    SecondActivity secondActivity = null;

    @Before
    public void setUp() throws Exception {
        secondActivity = mainTestRule.getActivity();
    }

    @Test
    public void TestLaunch()
    {
        RelativeLayout rlayout = secondActivity.findViewById(R.id.fragment_container);
        assertNotNull(rlayout);

        FragmentToTest fragment = new FragmentToTest();
        secondActivity.getFragmentManager().beginTransaction().add(rlayout.getId(), fragment).commitAllowingStateLoss();
        getInstrumentation().waitForIdleSync();
        View view = fragment.getView().findViewById(R.id.fragment1);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        secondActivity = null;
    }
}