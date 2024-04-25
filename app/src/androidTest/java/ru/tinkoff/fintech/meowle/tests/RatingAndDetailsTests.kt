package ru.tinkoff.fintech.meowle.tests

import androidx.test.espresso.Espresso.pressBack
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.runner.RunWith
import ru.tinkoff.fintech.meowle.espressoScreens.EspressoCatProfileScreen
import ru.tinkoff.fintech.meowle.espressoScreens.EspressoPageController
import ru.tinkoff.fintech.meowle.espressoScreens.EspressoRatingScreen
import ru.tinkoff.fintech.meowle.presentation.view.AuthActivity
import ru.tinkoff.fintech.meowle.rules.AuthPreferencesRule
import ru.tinkoff.fintech.meowle.utils.NavigationButton

@RunWith(AndroidJUnit4::class)
class RatingAndDetailsTests {

    private val activityScenarioRule = activityScenarioRule<AuthActivity>()
    private val preferencesRule = AuthPreferencesRule()

    @get:Rule
    val ruleChain: RuleChain = RuleChain.outerRule(preferencesRule).around(activityScenarioRule)
    @Test
    fun increasingCatLikeTest() {
        val pageController = EspressoPageController()
        val ratingScreen = EspressoRatingScreen()
        val profileScreen = EspressoCatProfileScreen()
        val expectedLikes = "1131"

        pageController.clickNavigationBarButton(NavigationButton.RATING)
        ratingScreen.waitForResults()
        ratingScreen.clickFirstCatAtRatingList()

        profileScreen.clickLikeButton()
        profileScreen.compareLikesCountWith(expectedLikes)

        pressBack()
        ratingScreen.isDisplayed()
    }

    @Test
    fun catDescriptionChangeTest() {
        val pageController = EspressoPageController()
        val ratingScreen = EspressoRatingScreen()
        val profileScreen = EspressoCatProfileScreen()

        pageController.clickNavigationBarButton(NavigationButton.RATING)

        ratingScreen.clickDislikesButton()
        ratingScreen.waitForResults()
        ratingScreen.clickFirstCatAtRatingList()

        val currentDescription = ""
        profileScreen.compareCatDescriptionWith(currentDescription)
        profileScreen.clickEditDescriptionButton()
        profileScreen.isDescriptionFieldEnabled()

        val newDescription = "Просто не повезло"
        profileScreen.changeDescriptionWith(newDescription)
        profileScreen.clickEditDescriptionButton()

        pressBack()
        ratingScreen.clickDislikesButton()
        ratingScreen.waitForResults()
        ratingScreen.clickFirstCatAtRatingList()

        profileScreen.compareCatDescriptionWith(newDescription)
    }
}