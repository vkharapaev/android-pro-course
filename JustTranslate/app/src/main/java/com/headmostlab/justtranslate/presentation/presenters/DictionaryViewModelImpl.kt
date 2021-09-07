package com.headmostlab.justtranslate.presentation.presenters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.headmostlab.justtranslate.domain.entities.Translations
import com.headmostlab.justtranslate.domain.interactors.DictionaryInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DictionaryViewModelImpl constructor(
    private val dictionaryInteractor: DictionaryInteractor
) : ViewModel() {

    private val translations = MutableLiveData<List<Translations>>()

    private var job: Job? = null

    fun search(word: String): LiveData<List<Translations>> {
        job?.cancel()
        job = viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    translations.postValue(emptyList())
                    val found = dictionaryInteractor.getTranslations(word)
                    translations.postValue(found)
                } catch (e: Throwable) {
                    e.printStackTrace()
                }
            }
        }
        return translations
    }
}