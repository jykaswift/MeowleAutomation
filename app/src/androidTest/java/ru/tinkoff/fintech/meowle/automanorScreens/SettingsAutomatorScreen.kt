package ru.tinkoff.fintech.meowle.automanorScreens

import androidx.test.uiautomator.By
import org.junit.Assert.assertEquals
import ru.tinkoff.fintech.meowle.R
import ru.tinkoff.fintech.meowle.utils.TestsConstants

class SettingsAutomatorScreen: BaseUiAutomatorScreen() {
    private val logoutButton = By.res(TestsConstants.PACKAGE_NAME, "logout_btn")

    fun clickLogout() {
        waitFindObject(logoutButton).click()
    }

    fun matchLogoutButtonNameLabelWith(name: String) {
        val actualLogoutLabel = waitFindObject(logoutButton).text
        val expectedNameLabel = resourceString(R.string.btn_logout) + " " + name
        assertEquals(expectedNameLabel, actualLogoutLabel)
    }
}