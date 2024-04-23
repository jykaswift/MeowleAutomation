package ru.tinkoff.fintech.meowle.espressoScreens

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.awaitility.kotlin.await
import org.hamcrest.Matchers.containsString
import ru.tinkoff.fintech.meowle.R
import ru.tinkoff.fintech.meowle.customMatchers.RecyclerViewMatchers
import java.util.concurrent.TimeUnit

class EspressoSearchScreen {
    private val searchTextField = withId(R.id.et_search)
    private val searchButton = withId(R.id.search_button)
    private val searchResults = withId(R.id.rv_search_result_list)
    fun typeSearchQuery(text: String) {
        onView(searchTextField).perform(replaceText(text), closeSoftKeyboard())
    }

    fun clickSearchButton() {
        onView(searchButton).perform(click())
    }

    fun waitForResults() {
        await.atMost(4, TimeUnit.SECONDS).untilAsserted {
            onView(searchResults).check(matches(hasMinimumChildCount(1)))
        }
    }

    fun checkFirstResultContains(text: String) {
        onView(searchResults)
            .check(
                matches(
                    RecyclerViewMatchers.atPosition(0, hasDescendant(withText(containsString(text))))
                )
            )
    }

    fun clickFirstResult() {
        onView(searchResults).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
    }

}