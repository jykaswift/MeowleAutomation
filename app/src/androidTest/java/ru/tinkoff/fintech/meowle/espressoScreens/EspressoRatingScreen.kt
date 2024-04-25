package ru.tinkoff.fintech.meowle.espressoScreens

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.awaitility.kotlin.await
import ru.tinkoff.fintech.meowle.R
import java.util.concurrent.TimeUnit

class EspressoRatingScreen {

    private val ratingList = withId(R.id.rv_cats_list)
    private val ratingTitle = withId(R.id.tw_rating_title)
    private val dislikeButton = withText(R.string.rating_tab_dislikes_title)

    fun clickDislikesButton() {
        onView(dislikeButton).perform(click())
    }

    fun waitForResults() {
        await.atMost(4, TimeUnit.SECONDS).untilAsserted {
            onView(ratingList).check(matches(hasMinimumChildCount(1)))
        }
    }

    fun clickFirstCatAtRatingList() {
        onView(ratingList)
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            ))
    }

    fun isDisplayed() {
        onView(ratingTitle).check(matches(ViewMatchers.isDisplayed()))
    }

}