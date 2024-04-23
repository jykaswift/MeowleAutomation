package ru.tinkoff.fintech.meowle.automanorScreens

import androidx.annotation.StringRes
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until

abstract class BaseUiAutomatorScreen {

    protected val instrumentationRegistry = InstrumentationRegistry.getInstrumentation()
    protected val uiDevice = UiDevice.getInstance(instrumentationRegistry)
    private val waitTimeout = 3_000L

    protected fun waitFindObject(selector: BySelector, timeout: Long = waitTimeout): UiObject2 {
        return uiDevice.wait(Until.findObject(selector), timeout)
    }

    protected fun waitHasObject(selector: BySelector, timeout: Long = waitTimeout) {
        uiDevice.wait(Until.hasObject(selector), timeout)
    }

    protected fun resourceString(@StringRes stringId: Int): String {
        return instrumentationRegistry.targetContext.getString(stringId)
    }
}