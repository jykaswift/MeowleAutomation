package ru.tinkoff.fintech.meowle.tests

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.fintech.meowle.automanorScreens.AuthAutomatorScreen
import ru.tinkoff.fintech.meowle.automanorScreens.AutomatorPageController
import ru.tinkoff.fintech.meowle.automanorScreens.SettingsAutomatorScreen
import ru.tinkoff.fintech.meowle.presentation.view.AuthActivity
import ru.tinkoff.fintech.meowle.utils.NavigationButton

@RunWith(AndroidJUnit4::class)
class AuthTests {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<AuthActivity>()

    @Test
    fun logoutTest() {
        val authScreen = AuthAutomatorScreen()
        val bottomNavigation = AutomatorPageController()
        val settingsScreen = SettingsAutomatorScreen()

        authScreen.enterName("Евгений")
        authScreen.enterPhone("+79643228023")
        authScreen.clickSubmit()

        bottomNavigation.clickNavigationBarButton(NavigationButton.SETTINGS)
        settingsScreen.clickLogout()

        authScreen.checkActivityIsOpen()
    }

    @Test
    fun nameMatchOnSettingsScreenTest() {
        val authScreen = AuthAutomatorScreen()
        val pageController = AutomatorPageController()
        val settingsScreen = SettingsAutomatorScreen()
        val name = "Евгений"

        authScreen.enterName(name)
        authScreen.enterPhone("+79643228023")
        authScreen.clickSubmit()

        pageController.clickNavigationBarButton(NavigationButton.SETTINGS)
        settingsScreen.matchLogoutButtonNameLabelWith(name)
    }
}
