package ru.tinkoff.fintech.meowle.rules

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class AuthPreferencesRule: TestRule {

    val meowlePrefs = InstrumentationRegistry
        .getInstrumentation().targetContext
        .getSharedPreferences("meowle", Context.MODE_PRIVATE)
    override fun apply(base: Statement?, description: Description?): Statement {
        return object: Statement() {
            override fun evaluate() {
                putAuthPreferences()
                base?.evaluate()
                clearAuthPreferences()
            }
        }
    }

    private fun putAuthPreferences() {
        meowlePrefs
            .edit()
            .putBoolean("auth", true)
            .putString("name", "Евгений")
            .commit()
    }

    private fun clearAuthPreferences() {
        meowlePrefs
            .edit()
            .clear()
            .commit()
    }


}