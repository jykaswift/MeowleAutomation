package ru.tinkoff.fintech.meowle.tests

import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.fintech.meowle.automanorScreens.AutomatorPageController
import ru.tinkoff.fintech.meowle.domain.cat.Gender
import ru.tinkoff.fintech.meowle.espressoScreens.EspressoAddCatScreen
import ru.tinkoff.fintech.meowle.espressoScreens.EspressoPageController
import ru.tinkoff.fintech.meowle.presentation.MainActivity
import ru.tinkoff.fintech.meowle.utils.IntentManager
import ru.tinkoff.fintech.meowle.utils.NavigationButton

@RunWith(AndroidJUnit4::class)
class AddCatTests {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun positiveAddingCatTest() {
        val pageController = AutomatorPageController()
        val addCatScreen = EspressoAddCatScreen()
        val catName = "алешкаалешка"
        val catDescription = "Просто кот"

        pageController.clickNavigationBarButton(NavigationButton.ADD)
        addCatScreen.enterName(catName)
        addCatScreen.setGender(Gender.MALE)
        addCatScreen.enterDescription(catDescription)
        addCatScreen.clickAddButton()
        // Тестирование toast невозможно с api 30+ версии
        // https://github.com/android/android-test/issues/803
        // Не через automator не через espresso

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