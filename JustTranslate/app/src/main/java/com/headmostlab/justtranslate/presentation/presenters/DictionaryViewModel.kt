package com.headmostlab.justtranslate.presentation.presenters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.headmostlab.justtranslate.domain.entities.Translations
import com.headmostlab.justtranslate.domain.interactors.DictionaryInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DictionaryViewModel(private val interactor: DictionaryInteractor) : ViewModel() {

    val translations = MutableLiveData<List<Translations>>()
    val defaultWord = MutableLiveData("word")

    fun search(word: String) = viewModelScope.launch(Dispatchers.IO) {
        translations.postValue(interactor.getTranslations(word))
    }

}