package ru.tinkoff.fintech.meowle.automanorScreens

import androidx.test.uiautomator.By
import org.junit.Assert.assertEquals
import ru.tinkoff.fintech.meowle.utils.TestsConstants

class AuthAutomatorScreen: BaseUiAutomatorScreen() {

    private val nameField = By.res(TestsConstants.PACKAGE_NAME, "et_name")
    private val phoneField = By.res(TestsConstants.PACKAGE_NAME, "et_phone")
    private val submitButton = By.res(TestsConstants.PACKAGE_NAME, "submit_button")

    fun enterName(name: String) {
        waitFindObject(nameField).text = name
    }

    fun enterPhone(phone: String) {
        waitFindObject(phoneField).text = phone
    }

    fun clickSubmit() {
        waitFindObject(submitButton).click()
    }

    fun checkActivityIsOpen() {
        val isButtonDisplayed = waitHasObject(submitButton)
        assertEquals(isButtonDisplayed, true)
    }
}