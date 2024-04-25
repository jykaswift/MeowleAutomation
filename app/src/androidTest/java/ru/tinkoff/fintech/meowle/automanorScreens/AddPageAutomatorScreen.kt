package ru.tinkoff.fintech.meowle.automanorScreens

import androidx.test.uiautomator.By
import ru.tinkoff.fintech.meowle.R
import ru.tinkoff.fintech.meowle.domain.cat.Gender
import ru.tinkoff.fintech.meowle.utils.TestsConstants

class AddPageAutomatorScreen: BaseUiAutomatorScreen() {
    private val nameTextField = By.res(TestsConstants.PACKAGE_NAME, "et_name")
    private val genderPicker = By.textContains("Пол")
    private val descriptionTextField = By.res(TestsConstants.PACKAGE_NAME, "cat_description")
    private val addButton = By.res(TestsConstants.PACKAGE_NAME, "btn_add")

    fun enterName(name: String) {
        waitFindObject(nameTextField).text = name
    }

    fun setGender(gender: Gender) {
        waitFindObject(genderPicker).click()
        val genderLabel: String = when (gender) {
            Gender.MALE -> resourceString(R.string.gender_male)
            Gender.FEMALE -> resourceString(R.string.gender_female)
            Gender.UNISEX -> resourceString(R.string.gender_unisex)
        }
        waitFindObject(By.text(genderLabel)).click()
    }

    fun enterDescription(description: String) {
        waitFindObject(descriptionTextField).text = description
    }

    fun clickAddButton() {
        waitFindObject(addButton).click()
    }

}