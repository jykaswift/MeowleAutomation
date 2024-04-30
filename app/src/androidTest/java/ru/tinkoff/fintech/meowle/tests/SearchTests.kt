package ru.tinkoff.fintech.meowle.tests

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.fintech.meowle.espressoScreens.EspressoCatProfileScreen
import ru.tinkoff.fintech.meowle.espressoScreens.EspressoSearchScreen
import ru.tinkoff.fintech.meowle.presentation.MainActivity

@RunWith(AndroidJUnit4::class)
class SearchTests {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun searchResultsTest() {
        val searchScreen = EspressoSearchScreen()
        val searchQuery = "кот"

        searchScreen.typeSearchQuery(searchQuery)
        searchScreen.clickSearchButton()
        searchScreen.waitForResults()

        searchScreen.checkFirstResultContainsText(searchQuery)
    }

    @Test
    fun openFirstCatPageBySearchResultsTest() {
        val searchScreen = EspressoSearchScreen()
        val catProfileScreen = EspressoCatProfileScreen()
        val searchQuery = "Большойкот"

        searchScreen.typeSearchQuery(searchQuery)
        searchScreen.clickSearchButton()
        searchScreen.waitForResults()
        searchScreen.clickFirstResultItem()

        catProfileScreen.compareDetailTitleNameWith(searchQuery)
    }

}