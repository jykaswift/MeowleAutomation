package ru.tinkoff.fintech.meowle.espressoScreens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isPlatformPopup
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import ru.tinkoff.fintech.meowle.R
import ru.tinkoff.fintech.meowle.domain.cat.Gender


class EspressoAddCatScreen {

    private val successSnackbar = withText(R.string.add_snackbar_success_message)
    private val nameTextField = withId(R.id.et_name)
    private val descriptionTextField = withId(R.id.cat_description)
    private val pickPhotoButton = withId(R.id.iw_add_cat_avatar)
    private val genderPicker = withHint(R.string.gender)
    private val addButton = withId(R.id.btn_add)

    fun enterName(name: String) {
        onView(nameTextField).perform(replaceText(name))
    }

    fun enterDescription(description: String) {
        onView(descriptionTextField).perform(replaceText(description))
    }

    fun setGender(gender: Gender) {
        onView(genderPicker).perform(click())
        val genderMatcher = when (gender) {
            Gender.MALE -> withText(R.string.gender_male)
            Gender.FEMALE -> withText(R.string.gender_female)
            Gender.UNISEX -> withText(R.string.gender_unisex)
        }

        onView(genderMatcher).inRoot(isPlatformPopup()).perform(click())
    }

    fun clickAddButton() {
        onView(addButton).perform(click())
    }

    fun clickPhotoButton() {
        onView(pickPhotoButton).perform(click())
    }

    fun checkSuccessSnackBarAppear() {
        onView(successSnackbar).check(matches(isDisplayed()))
    }
}