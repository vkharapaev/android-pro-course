package com.headmostlab.justtranslate.presentation.presenters

import com.headmostlab.justtranslate.domain.entities.Translations
import com.headmostlab.justtranslate.domain.interactors.DictionaryInteractor
import com.headmostlab.justtranslate.domain.interactors.interfaces.Schedulers
import com.headmostlab.justtranslate.domain.interactors.interfaces.presenters.DictionaryPresenter
import com.headmostlab.justtranslate.domain.interactors.interfaces.presenters.list.TranslationsListPresenter
import com.headmostlab.justtranslate.presentation.presenters.interfaces.ui.DictionaryView
import com.headmostlab.justtranslate.presentation.presenters.interfaces.ui.list.TranslationsView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class DictionaryPresenterImpl @Inject constructor(
    private val dictionaryInteractor: DictionaryInteractor,
    private val schedulers: Schedulers
) : DictionaryPresenter {

    private var view: DictionaryView? = null

    private val disposables = CompositeDisposable()

    private val translationsListPresenter: TranslationsListPresenterImpl =
        TranslationsListPresenterImpl()

    override fun attachView(view: DictionaryView) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun search(word: String) {
        disposables.clear()
        disposables.add(
            dictionaryInteractor.getTranslations(word)
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .doOnSubscribe {
                    view?.updateTranslationsList()
                }
                .subscribe({
                    translationsListPresenter.setData(it)
                    view?.updateTranslationsList()
                }, {
                    it.printStackTrace()
                })
        )
    }

    override fun getTranslationsListPresenter(): TranslationsListPresenter {
        return translationsListPresenter
    }

    private inner class TranslationsListPresenterImpl : TranslationsListPresenter {

        private val data = mutableListOf<Translations>()

        fun setData(data: List<Translations>) {
            this.data.clear()
            this.data.addAll(data)
        }

        override fun bindView(view: TranslationsView) =
            view.setTranslations(data[view.position()].toString())

        override fun getCount(): Int = data.size

    }

}