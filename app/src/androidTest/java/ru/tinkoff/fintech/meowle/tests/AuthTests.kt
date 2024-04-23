package ru.tinkoff.fintech.meowle.tests

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.fintech.meowle.automanorScreens.AuthAutomatorScreen
import ru.tinkoff.fintech.meowle.automanorScreens.BottomNavigationAutomator
import ru.tinkoff.fintech.meowle.automanorScreens.SettingsAutomatorScreen
import ru.tinkoff.fintech.meowle.presentation.view.AuthActivity

@RunWith(AndroidJUnit4::class)
class AuthTests {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<AuthActivity>()

    @Test
    fun logoutTest() {
        val authScreen = AuthAutomatorScreen()
        val bottomNavigation = BottomNavigationAutomator()
        val settingsScreen = SettingsAutomatorScreen()

        authScreen.enterName("Евгений")
        authScreen.enterPhone("+79643228023")
        authScreen.clickSubmit()
        bottomNavigation.clickNavigationBarButton(BottomNavigationAutomator.NavigationButton.SETTINGS)
        settingsScreen.clickLogout()
        authScreen.checkActivityIsOpen()
    }

    @Test
    fun nameMatchOnSettingsScreenTest() {
        val authScreen = AuthAutomatorScreen()
        val bottomNavigation = BottomNavigationAutomator()
        val settingsScreen = SettingsAutomatorScreen()
        val name = "Евгений"
        authScreen.enterName(name)
        authScreen.enterPhone("+79643228023")
        authScreen.clickSubmit()
        bottomNavigation.clickNavigationBarButton(BottomNavigationAutomator.NavigationButton.SETTINGS)
        settingsScreen.matchLogoutButtonNameLabelWith(name)
    }
}
