package ru.tinkoff.fintech.meowle.tests

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.runner.RunWith
import ru.tinkoff.fintech.meowle.espressoScreens.EspressoCatProfileScreen
import ru.tinkoff.fintech.meowle.espressoScreens.EspressoSearchScreen
import ru.tinkoff.fintech.meowle.presentation.view.AuthActivity
import ru.tinkoff.fintech.meowle.rules.AuthPreferencesRule

@RunWith(AndroidJUnit4::class)
class SearchTests {

    private val activityScenarioRule = activityScenarioRule<AuthActivity>()

    private val preferencesRule = AuthPreferencesRule()

    @get:Rule
    val ruleChain: RuleChain = RuleChain.outerRule(preferencesRule).around(activityScenarioRule)

    @Test
    fun searchResultsTest() {
        val searchScreen = EspressoSearchScreen()
        searchScreen.typeSearchQuery("кот")
        searchScreen.clickSearchButton()
        searchScreen.waitForResults()
        searchScreen.checkFirstResultContains("кот")
    }

    @Test
    fun openFirstCatPageBySearchResultsTest() {
        val searchScreen = EspressoSearchScreen()
        val catProfileScreen = EspressoCatProfileScreen()
        searchScreen.typeSearchQuery("кот")
        searchScreen.clickSearchButton()
        searchScreen.waitForResults()
        searchScreen.clickFirstResult()
        catProfileScreen.compareDetailTitleNameWith("Артемовкот")
    }

}