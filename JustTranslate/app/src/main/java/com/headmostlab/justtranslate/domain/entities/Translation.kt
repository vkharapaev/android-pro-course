package com.headmostlab.justtranslate.domain.entities

data class Translations(
    val text: String?,
    val meaning: List<Meanings>?
)

data class Meanings(
    val translation: Translation?,
    val imageUrl: String?
)

data class Translation(
    val text: String?
)
