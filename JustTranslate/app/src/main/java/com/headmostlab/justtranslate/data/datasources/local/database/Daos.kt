package com.headmostlab.justtranslate.data.datasources.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.headmostlab.justtranslate.domain.entities.Translations

@Dao
abstract class AllDao {

    @Insert
    abstract suspend fun insertMeanings(meanings: List<MeaningEntity>)

    @Insert
    abstract suspend fun insertTranslations(translations: TranslationsEntity): Long

    @Transaction
    open suspend fun insert(translations: Translations) {
        val translationsId = insertTranslations(DataConverter.map(translations))
        val meanings = translations.meanings?.map { DataConverter.map(translationsId.toInt(), it) }
            ?: emptyList()
        insertMeanings(meanings)
    }

    @Transaction
    open suspend fun insert(translations: List<Translations>) {
        translations.forEach { insert(it) }
    }

    @Transaction
    @Query("SELECT * FROM TRANSLATIONSENTITY WHERE text like :text")
    abstract suspend fun find(text: String): List<TranslationsWithMeaningsEntity>
}