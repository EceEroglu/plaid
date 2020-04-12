package io.plaidapp.ui

import android.content.Context
import android.view.Gravity
import android.widget.TextView
import android.widget.Toolbar
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import io.plaidapp.R
import org.hamcrest.CoreMatchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Suite


@RunWith(AndroidJUnit4::class)
@Suite.SuiteClasses(SearchActivityTest::class, ToolbarItemsTest::class)


class ToolbarItemsTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(HomeActivity::class.java)


    @Test
    @Throws(Exception::class)
    fun verifyOverflowMenuItemAbout() {

     openActionBarOverflowOrOptionsMenu(
         ApplicationProvider.getApplicationContext<Context>())

        onView(withText("About")).check(matches(isDisplayed()))

        }



    @Test
    fun checkMenuTheme() {

        onView(withId(R.id.menu_theme))
            .perform(ViewActions.click())
            .check(matches(withId(R.color.designer_news_variant)))
        Thread.sleep(800)
    }


    @Test
   fun verifyToolbarTitle() {

        onView(
            CoreMatchers.allOf(
                isAssignableFrom(TextView::class.java),
                withParent(isAssignableFrom(Toolbar::class.java))
            )
        )

            .check(matches(withText("Plaid")))

    }

    @Test
    fun checkPressFilterButtonOpensDrawer() {

        onView(withId(R.id.drawer)).check(matches(DrawerMatchers.isClosed(Gravity.END)))
        onView(withId(R.id.menu_filter)).perform(ViewActions.click())

        onView(withId(R.id.drawer)).check(matches(DrawerMatchers.isOpen(Gravity.END)))

    }



}


