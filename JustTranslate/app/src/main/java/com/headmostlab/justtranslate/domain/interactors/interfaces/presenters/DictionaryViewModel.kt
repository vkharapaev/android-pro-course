package com.headmostlab.justtranslate.domain.interactors.interfaces.presenters

import androidx.lifecycle.LiveData
import com.headmostlab.justtranslate.domain.entities.Translations

interface DictionaryViewModel {
    fun search(word: String): LiveData<List<Translations>>
}