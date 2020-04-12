package io.plaidapp.ui

import android.widget.EditText
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import io.plaidapp.R
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SearchActivityTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(HomeActivity::class.java)



    @Test
    fun verifySearchFunction() {

       onView(ViewMatchers.withId(R.id.menu_search)).perform(click())
        Thread.sleep(800)
        onView(isAssignableFrom(EditText::class.java)).perform(
            typeText("work"),
            pressImeActionButton()
        )
        Thread.sleep(800)

      onData(
           allOf(
             CoreMatchers.`is`(Matchers.instanceOf(String::class.java)),
             withText("work")
            )).check(matches(isDisplayed()))


    }

    }
