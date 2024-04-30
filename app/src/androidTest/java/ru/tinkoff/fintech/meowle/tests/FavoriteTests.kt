package ru.tinkoff.fintech.meowle.tests

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.fintech.meowle.espressoScreens.EspressoCatProfileScreen
import ru.tinkoff.fintech.meowle.espressoScreens.EspressoFavoriteScreen
import ru.tinkoff.fintech.meowle.espressoScreens.EspressoPageController
import ru.tinkoff.fintech.meowle.espressoScreens.EspressoRatingScreen
import ru.tinkoff.fintech.meowle.presentation.MainActivity
import ru.tinkoff.fintech.meowle.utils.NavigationButton

@RunWith(AndroidJUnit4::class)
class FavoriteTests {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun addFavoriteFromDetailViaRatingList() {
        val pageController = EspressoPageController()
        val ratingScreen = EspressoRatingScreen()
        val profileScreen = EspressoCatProfileScreen()
        val favoriteScreen = EspressoFavoriteScreen()
        val targetCatName = "Жевоыьторп"

        pageController.clickNavigationBarButton(NavigationButton.RATING)
        ratingScreen.waitForResults()
        ratingScreen.clickFirstCatAtRatingList()

        profileScreen.clickFavoriteButton()
        pageController.clickNavigationBarButton(NavigationButton.FAVORITE)

        favoriteScreen.findCatBy(targetCatName)
    }
}