package com.headmostlab.justtranslate.presentation.presenters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.headmostlab.justtranslate.domain.entities.Translations
import com.headmostlab.justtranslate.domain.interactors.DictionaryInteractor
import com.headmostlab.justtranslate.domain.interactors.interfaces.Schedulers
import com.headmostlab.justtranslate.domain.interactors.interfaces.presenters.DictionaryViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

class DictionaryViewModelImpl constructor(
    private val dictionaryInteractor: DictionaryInteractor,
    private val schedulers: Schedulers
) : ViewModel(), DictionaryViewModel {

    private val disposables = CompositeDisposable()

    private val translations = MutableLiveData<List<Translations>>()

    override fun search(word: String): LiveData<List<Translations>> {
        disposables.clear()
        disposables.add(
            dictionaryInteractor.getTranslations(word)
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .doOnSubscribe {
                    translations.value = emptyList()
                }
                .subscribe({
                    translations.value = it
                }, {
                    it.printStackTrace()
                })
        )
        return translations
    }

    override fun onCleared() = disposables.clear()
}