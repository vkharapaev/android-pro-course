package com.headmostlab.justtranslate.domain.entities

import com.google.gson.annotations.Expose

data class Translations(
    @Expose val text: String?,
    @Expose val meaning: List<Meanings>?
)

data class Meanings(
    @Expose val translation: Translation?,
    @Expose val imageUrl: String?
)

data class Translation(
    @Expose val text: String?
)
