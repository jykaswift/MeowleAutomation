package ru.tinkoff.fintech.meowle.espressoScreens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.awaitility.kotlin.await
import ru.tinkoff.fintech.meowle.R
import ru.tinkoff.fintech.meowle.customMatchers.DrawableMatcher
import ru.tinkoff.fintech.meowle.customMatchers.EndTextMatcher
import java.util.concurrent.TimeUnit


class EspressoCatProfileScreen {

    private val detailsTitle = withId(R.id.tw_details_title)
    private val likeButton = withId(R.id.ib_like)
    private val catLikes = withId(R.id.cat_likes)
    private val editDescriptionButton = withId(R.id.btn_edit)
    private val catDescription = withId(R.id.cat_description)
    private val favoriteButton = withId(R.id.ib_favorite)

    fun checkFavoriteButtonIsPressed() {
        // Задержка нужна чтобы ViewModel успел обновить состояние кнопки
        await.atMost(2, TimeUnit.SECONDS).untilAsserted {
            onView(favoriteButton).check(matches(DrawableMatcher(R.drawable.ic_favourite_pressed)))
        }
    }

    fun compareDetailTitleNameWith(titleName: String) {
        val expectedTitle = "Досье по $titleName"
        onView(detailsTitle).check(matches(withText(expectedTitle)))
    }

    fun clickLikeButton() {
        onView(likeButton).perform(click())
    }

    fun compareLikesCountWith(count: String) {
        await.atMost(2, TimeUnit.SECONDS).untilAsserted {
            onView(catLikes).check(matches(EndTextMatcher(count)))
        }
    }

    fun compareCatDescriptionWith(text: String) {
        onView(catDescription).check(matches(withText(text)))
    }

    fun clickEditDescriptionButton() {
        onView(editDescriptionButton).perform(click())
    }

    fun isDescriptionFieldEnabled() {
        onView(catDescription).check(matches(isEnabled()))
    }

    fun changeDescriptionWith(text: String) {
        onView(catDescription).perform(replaceText(text))
    }

    fun clickFavoriteButton() {
        onView(favoriteButton).perform(click())
    }


}