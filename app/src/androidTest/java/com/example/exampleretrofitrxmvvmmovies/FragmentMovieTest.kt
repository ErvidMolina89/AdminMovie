package com.example.exampleretrofitrxmvvmmovies

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class FragmentMovieTest {

    @get:Rule
    var mActivityTestRule: ActivityTestRule<MainActivity?>? =
        ActivityTestRule(MainActivity::class.java)

    @Test
    fun testClickOnRecyclerViewItem() {
        // Espera a que el RecyclerView esté visible
        Thread.sleep(5000)
        onView(withId(R.id.recyclerView))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        Thread.sleep(5000)

        // Puedes agregar más acciones según tus necesidades, como verificar el texto u otros elementos en la vista siguiente.
        onView(withId(R.id.tv_name_detail)).check(matches(withText("WATCHMEN")))
    }
}