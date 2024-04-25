package ru.tinkoff.fintech.meowle.espressoScreens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import ru.tinkoff.fintech.meowle.R


class EspressoAddCatScreen {

    private val successSnackbar = withText(R.string.add_snackbar_success_message)
    private val pickPhotoButton = withId(R.id.iw_add_cat_avatar)

    fun clickPhotoButton() {
        onView(pickPhotoButton).perform(click())
    }

    fun checkSuccessSnackBarAppear() {
        onView(successSnackbar).check(matches(isDisplayed()))
    }
}