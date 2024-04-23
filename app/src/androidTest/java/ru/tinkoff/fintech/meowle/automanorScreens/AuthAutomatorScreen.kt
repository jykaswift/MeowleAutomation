package ru.tinkoff.fintech.meowle.automanorScreens

import androidx.test.uiautomator.By
import ru.tinkoff.fintech.meowle.TestsConstants

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
        waitHasObject(submitButton, 10000L)
    }
}