package ru.tinkoff.fintech.meowle.tests

import androidx.test.espresso.Espresso
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.runner.RunWith
import ru.tinkoff.fintech.meowle.domain.cat.Cat
import ru.tinkoff.fintech.meowle.domain.cat.Gender
import ru.tinkoff.fintech.meowle.espressoScreens.EspressoCatProfileScreen
import ru.tinkoff.fintech.meowle.espressoScreens.EspressoFavoriteScreen
import ru.tinkoff.fintech.meowle.espressoScreens.EspressoPageController
import ru.tinkoff.fintech.meowle.presentation.MainActivity
import ru.tinkoff.fintech.meowle.rules.AddCatToFavoriteRule
import ru.tinkoff.fintech.meowle.utils.NavigationButton

@RunWith(AndroidJUnit4::class)
class FavoriteTestsWithMockedData {

    private val activityScenarioRule = activityScenarioRule<MainActivity>()
    private val addCatToFavorite = AddCatToFavoriteRule(
        Cat(
        17650L,
        "Кицвунг",
        "",
        Gender.UNISEX, 0,
        0
    )
    )

    @get:Rule
    val ruleChain: RuleChain = RuleChain.outerRule(activityScenarioRule).around(addCatToFavorite)

    @Test
    fun removeCatFromFavoritesTest() {
        val pageController = EspressoPageController()
        val favoriteScreen = EspressoFavoriteScreen()
        val profileScreen = EspressoCatProfileScreen()
        val targetCatName = "Кицвунг"

        pageController.clickNavigationBarButton(NavigationButton.FAVORITE)
        favoriteScreen.clickCatWith(targetCatName)
        profileScreen.checkFavoriteButtonIsPressed()
        profileScreen.clickFavoriteButton()

        Espresso.pressBack()
        favoriteScreen.checkCatDoesNotExistBy(targetCatName)
    }
}