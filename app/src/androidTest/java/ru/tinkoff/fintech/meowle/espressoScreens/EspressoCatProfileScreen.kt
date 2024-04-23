package ru.tinkoff.fintech.meowle.espressoScreens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import ru.tinkoff.fintech.meowle.R

class EspressoCatProfileScreen {

    private val detailsTitle = withId(R.id.tw_details_title)
    fun compareDetailTitleNameWith(name: String) {
        val expectedTitle = "Досье по $name"
        onView(detailsTitle).check(matches(withText(expectedTitle)))
    }
}