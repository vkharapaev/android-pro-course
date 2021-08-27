package com.headmostlab.justtranslate.domain.interactors.interfaces.presenters

import com.headmostlab.justtranslate.domain.interactors.interfaces.presenters.list.TranslationsListPresenter
import com.headmostlab.justtranslate.presentation.presenters.interfaces.ui.DictionaryView

interface DictionaryPresenter {
    fun attachView(view: DictionaryView)
    fun detachView()
    fun search(word: String)
    fun getTranslationsListPresenter(): TranslationsListPresenter
}