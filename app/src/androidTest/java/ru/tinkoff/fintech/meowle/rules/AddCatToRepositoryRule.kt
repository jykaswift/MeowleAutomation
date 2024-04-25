package ru.tinkoff.fintech.meowle.rules

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking
import org.junit.rules.TestRule
import ru.tinkoff.fintech.meowle.domain.repository.CatRepository
import org.junit.runners.model.Statement
import org.junit.runner.Description
import ru.tinkoff.fintech.meowle.data.api.CatsApi
import ru.tinkoff.fintech.meowle.data.database.CatsDatabase
import ru.tinkoff.fintech.meowle.data.repository.CatsRepositoryImpl
import ru.tinkoff.fintech.meowle.di.AppModule
import ru.tinkoff.fintech.meowle.domain.cat.Cat
import ru.tinkoff.fintech.meowle.domain.cat.Gender

class AddCatToDbRule(private val cat: Cat) : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                val catRepository = createRepository()

                saveCatToRepository(cat, catRepository )
                base.evaluate()
                removeCatFromRepository(cat, catRepository)
            }
        }
    }

    private fun createRepository(): CatsRepositoryImpl {
        val context: Context = ApplicationProvider.getApplicationContext()
        val catsDatabase: CatsDatabase = AppModule.provideYourDatabase(context)
        val catsApi: CatsApi = AppModule.provideCatsApi()

        return CatsRepositoryImpl(catsApi, catsDatabase.catsDao())
    }

    private fun saveCatToRepository(cat: Cat, catRepository: CatRepository) {

        runBlocking {
            catRepository.addToFavourites(cat)
        }
    }

    private fun removeCatFromRepository(cat: Cat, catRepository: CatRepository) {
        runBlocking {
            catRepository.removeFromFavourites(cat.id)
        }
    }
}