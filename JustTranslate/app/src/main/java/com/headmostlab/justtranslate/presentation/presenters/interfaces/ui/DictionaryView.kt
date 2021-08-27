package com.headmostlab.justtranslate.presentation.presenters.interfaces.ui

interface DictionaryView {
    fun showError(message: String)
    fun updateTranslationsList()
}