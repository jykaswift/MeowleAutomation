package ru.tinkoff.fintech.meowle.customMatchers

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher

class RecyclerViewMatcher(
    private val position: Int,
    private val itemMatcher: Matcher<View>
) : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
    override fun describeTo(description: Description) {
        description.appendText("has item at position $position: ")
    }

    override fun matchesSafely(recyclerView: RecyclerView): Boolean {
        val viewHolder = recyclerView.findViewHolderForAdapterPosition(position)
            ?:
            return false
        return itemMatcher.matches(viewHolder.itemView)
    }

}