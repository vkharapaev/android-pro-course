package com.headmostlab.justtranslate.presentation.presenters.interfaces.ui.list

interface TranslationsView {
    fun setTranslations(translations: String)
    fun position(): Int
}