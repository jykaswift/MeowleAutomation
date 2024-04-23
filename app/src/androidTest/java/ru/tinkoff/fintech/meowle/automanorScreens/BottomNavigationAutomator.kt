package ru.tinkoff.fintech.meowle.automanorScreens

import androidx.test.uiautomator.By
import androidx.test.uiautomator.BySelector
import ru.tinkoff.fintech.meowle.TestsConstants

class BottomNavigationAutomator: BaseUiAutomatorScreen() {
    enum class NavigationButton(val selector: BySelector) {
        RATING(By.res(TestsConstants.PACKAGE_NAME, "tab_btn_rating")),
        SEARCH(By.res(TestsConstants.PACKAGE_NAME, "tab_btn_search")),
        ADD(By.res(TestsConstants.PACKAGE_NAME, "tab_btn_add")),
        FAVORITE(By.res(TestsConstants.PACKAGE_NAME, "tab_btn_favourite")),
        SETTINGS(By.res(TestsConstants.PACKAGE_NAME, "tab_btn_settings")),
    }

    fun clickNavigationBarButton(button: NavigationButton) {
        val selector = button.selector
        waitFindObject(button.selector).click()
    }
}