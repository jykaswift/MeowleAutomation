package ru.tinkoff.fintech.meowle.customMatchers

import android.view.View
import androidx.test.espresso.matcher.BoundedMatcher
import com.google.android.material.textview.MaterialTextView
import org.hamcrest.Description

class EndTextMatcher(private val expectedEnd: String) : BoundedMatcher<View, MaterialTextView>(MaterialTextView::class.java) {
    override fun describeTo(description: Description?) {
        description?.appendText("with end text: $expectedEnd")
    }

    override fun matchesSafely(materialView: MaterialTextView): Boolean {
        val currentText = materialView.text
        return currentText.endsWith(expectedEnd)
    }

    override fun describeMismatch(item: Any, mismatchDescription: Description) {
        val actualText = (item as MaterialTextView).text.toString()
        mismatchDescription.appendText("Text in MaterialTextView was: $actualText")
    }

}