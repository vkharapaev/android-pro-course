package com.headmostlab.justtranslate.domain.interactors.interfaces.presenters.list

import com.headmostlab.justtranslate.presentation.presenters.interfaces.ui.list.TranslationsView

interface TranslationsListPresenter {
    companion object {
        const val NO_POSITION = -1
    }

    fun bindView(view: TranslationsView)

    fun getCount(): Int
}