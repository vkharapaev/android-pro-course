package com.headmostlab.justtranslate.data.datasources.local.database

import com.headmostlab.justtranslate.domain.entities.Meaning
import com.headmostlab.justtranslate.domain.entities.Translation
import com.headmostlab.justtranslate.domain.entities.Translations

class DataConverter {
    companion object {

        fun map(translations: Translations): TranslationsEntity =
            TranslationsEntity(null, translations.text)

        fun map(transId: Int, meaning: Meaning): MeaningEntity =
            MeaningEntity(null, transId, meaning.translation?.text, meaning.imageUrl)

        fun map(data: TranslationsWithMeaningsEntity): Translations {
            val meanings = data.meanings.map { map(it) }
            return Translations(data.translations.text, meanings)
        }

        fun map(data: MeaningEntity): Meaning =
            Meaning(Translation(data.translation), data.imageUrl)

    }
}