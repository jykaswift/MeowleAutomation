package ru.tinkoff.fintech.meowle.espressoScreens


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import ru.tinkoff.fintech.meowle.R
import ru.tinkoff.fintech.meowle.utils.NavigationButton

class EspressoPageController {
    fun clickNavigationBarButton(button: NavigationButton) {
        val matcher = when (button) {
            NavigationButton.RATING -> withId(R.id.tab_btn_rating)
            NavigationButton.SEARCH -> withId(R.id.tab_btn_search)
            NavigationButton.ADD -> withId(R.id.tab_btn_add)
            NavigationButton.FAVORITE -> withId(R.id.tab_btn_favourite)
            NavigationButton.SETTINGS -> withId(R.id.tab_btn_settings)
        }
        onView(matcher).perform(click())
    }

}