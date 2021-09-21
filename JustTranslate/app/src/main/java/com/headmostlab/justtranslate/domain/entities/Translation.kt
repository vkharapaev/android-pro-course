package com.headmostlab.justtranslate.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Translations(
    val text: String?,
    val meanings: List<Meaning>?
): Parcelable

@Parcelize
data class Meaning(
    val translation: Translation?,
    val imageUrl: String?
): Parcelable

@Parcelize
data class Translation(
    val text: String?
): Parcelable
