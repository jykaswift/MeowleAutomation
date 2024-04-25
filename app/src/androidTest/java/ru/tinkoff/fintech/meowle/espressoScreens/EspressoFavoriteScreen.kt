package ru.tinkoff.fintech.meowle.espressoScreens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers.not
import ru.tinkoff.fintech.meowle.R

class EspressoFavoriteScreen {
    fun findCatBy(name: String) {

        onView(withText(name)).check(matches(isDisplayed()))
    }

    fun checkCatDoesNotExistBy(name: String) {
        onView(withText(name)).check(doesNotExist())
    }

    fun clickCatWith(name: String) {
        onView(withText(name)).perform(click())
    }

}