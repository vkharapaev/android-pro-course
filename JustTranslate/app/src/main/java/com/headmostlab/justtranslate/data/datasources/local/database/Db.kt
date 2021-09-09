package com.headmostlab.justtranslate.data.datasources.local.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TranslationsEntity::class, MeaningEntity::class],
    version = 1,
    exportSchema = false
)
abstract class Db : RoomDatabase() {
    abstract fun allDao(): AllDao
}