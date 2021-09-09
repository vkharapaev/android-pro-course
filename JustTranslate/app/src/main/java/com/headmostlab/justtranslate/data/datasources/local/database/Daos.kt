package com.headmostlab.justtranslate.data.datasources.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
abstract class AllDao {

    @Insert
    abstract fun insertMeanings(meanings: List<MeaningEntity>)

    @Insert
    abstract fun insertTranslations(meanings: TranslationsEntity): Long

    @Transaction
    fun insert(translationsWithMeaningsEntity: TranslationsWithMeaningsEntity) {
        val translationsId = insertTranslations(translationsWithMeaningsEntity.translations)
        translationsWithMeaningsEntity.meanings
    }

    @Transaction
    @Query("SELECT * FROM TRANSLATIONSENTITY WHERE text like :text")
    abstract fun find(text: String): List<TranslationsWithMeaningsEntity>
}