package ru.tinkoff.fintech.meowle.tests

import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.runner.RunWith
import ru.tinkoff.fintech.meowle.automanorScreens.AddPageAutomatorScreen
import ru.tinkoff.fintech.meowle.automanorScreens.AutomatorPageController
import ru.tinkoff.fintech.meowle.domain.cat.Gender
import ru.tinkoff.fintech.meowle.espressoScreens.EspressoAddCatScreen
import ru.tinkoff.fintech.meowle.espressoScreens.EspressoPageController
import ru.tinkoff.fintech.meowle.presentation.view.AuthActivity
import ru.tinkoff.fintech.meowle.rules.AuthPreferencesRule
import ru.tinkoff.fintech.meowle.utils.IntentManager
import ru.tinkoff.fintech.meowle.utils.NavigationButton


@RunWith(AndroidJUnit4::class)
class AddCatTests {

    private val activityScenarioRule = activityScenarioRule<AuthActivity>()
    private val preferencesRule = AuthPreferencesRule()

    @get:Rule
    val ruleChain: RuleChain = RuleChain.outerRule(preferencesRule).around(activityScenarioRule)

    @Test
    fun positiveAddingCatTest() {
        val pageController = AutomatorPageController()
        val addPageScreen = AddPageAutomatorScreen()
        val espressoAddCatScreen = EspressoAddCatScreen()

        pageController.clickNavigationBarButton(NavigationButton.ADD)
        addPageScreen.enterName("Кошкакэт")
        addPageScreen.setGender(Gender.MALE)
        addPageScreen.enterDescription("Описание")
        addPageScreen.clickAddButton()

        espressoAddCatScreen.checkSuccessSnackBarAppear()
    }
    @Test
    fun openPhotoPickerTest() {
        Intents.init()
        val pageController = EspressoPageController()
        val espressoAddCatScreen = EspressoAddCatScreen()
        pageController.clickNavigationBarButton(NavigationButton.ADD)
        espressoAddCatScreen.clickPhotoButton()
        IntentManager.checkOpenedIntentWith("android.provider.action.PICK_IMAGES", 1)
        Intents.release()
    }
}