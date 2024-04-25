package ru.tinkoff.fintech.meowle.automanorScreens

import androidx.test.uiautomator.By
import ru.tinkoff.fintech.meowle.utils.NavigationButton
import ru.tinkoff.fintech.meowle.utils.TestsConstants

class AutomatorPageController: BaseUiAutomatorScreen() {

    fun clickNavigationBarButton(button: NavigationButton) {
        val selector = when (button) {
            NavigationButton.RATING -> By.res(TestsConstants.PACKAGE_NAME, "tab_btn_rating")
            NavigationButton.SEARCH -> By.res(TestsConstants.PACKAGE_NAME, "tab_btn_search")
            NavigationButton.ADD -> By.res(TestsConstants.PACKAGE_NAME, "tab_btn_add")
            NavigationButton.FAVORITE -> By.res(TestsConstants.PACKAGE_NAME, "tab_btn_favourite")
            NavigationButton.SETTINGS -> By.res(TestsConstants.PACKAGE_NAME, "tab_btn_settings")
        }

        waitFindObject(selector).click()
    }
}