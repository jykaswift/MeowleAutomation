package ru.tinkoff.fintech.meowle.utils

import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.VerificationModes
import androidx.test.espresso.intent.matcher.IntentMatchers

object IntentManager {
    fun checkOpenedIntentWith(action: String, times: Int) {
        Intents.intended(IntentMatchers.hasAction(action), VerificationModes.times(times))
    }
}