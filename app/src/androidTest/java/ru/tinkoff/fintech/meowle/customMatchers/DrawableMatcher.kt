package ru.tinkoff.fintech.meowle.customMatchers

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description

class DrawableMatcher(private val drawableResId: Int) : BoundedMatcher<View, ImageView>(ImageView::class.java) {
    override fun describeTo(description: Description?) {
        description?.appendText("has image drawable resource $drawableResId")
    }

    override fun matchesSafely(imageView: ImageView): Boolean {
        val expectedDrawable = ContextCompat.getDrawable(imageView.context, drawableResId)
            ?: return false

        val bitmap = (imageView.drawable as BitmapDrawable).bitmap
        val otherBitmap = (expectedDrawable as BitmapDrawable).bitmap
        return bitmap.sameAs(otherBitmap)
    }


}