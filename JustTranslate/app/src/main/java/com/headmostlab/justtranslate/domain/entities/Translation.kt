package com.headmostlab.justtranslate.domain.entities

data class Translations(
    val text: String?,
    val meanings: List<Meaning>?
)

data class Meaning(
    val translation: Translation?,
    val imageUrl: String?
)

data class Translation(
    val text: String?
)
