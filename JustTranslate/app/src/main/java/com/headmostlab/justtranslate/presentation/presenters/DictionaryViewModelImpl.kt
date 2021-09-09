package com.headmostlab.justtranslate.presentation.presenters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.headmostlab.justtranslate.domain.entities.Translations
import com.headmostlab.justtranslate.domain.interactors.DictionaryInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DictionaryViewModelImpl constructor(
    private val dictionaryInteractor: DictionaryInteractor
) : ViewModel() {

    private val _translations = MutableLiveData<List<Translations>>()
    val translations: LiveData<List<Translations>> = _translations

    private val _defaultWord = MutableLiveData("word")
    val defaultWord: LiveData<String> = _defaultWord

    fun search(word: String) = viewModelScope.launch(Dispatchers.IO) {
        _translations.postValue(dictionaryInteractor.getTranslations(word))
    }

}