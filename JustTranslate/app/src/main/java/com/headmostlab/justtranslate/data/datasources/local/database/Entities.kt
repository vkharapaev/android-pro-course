package com.headmostlab.justtranslate.data.datasources.local.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class TranslationsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val text: String?
)

@Entity
data class MeaningEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val translationsId: Int,
    val translation: String?,
    val imageUrl: String?
)

data class TranslationsWithMeaningsEntity(
    @Embedded val translations: TranslationsEntity,
    @Relation(parentColumn = "id", entityColumn = "translationsId")
    val meanings: List<MeaningEntity>
)