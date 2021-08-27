package com.headmostlab.justtranslate.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.headmostlab.justtranslate.databinding.TranslationsItemBinding
import com.headmostlab.justtranslate.domain.interactors.interfaces.presenters.list.TranslationsListPresenter
import com.headmostlab.justtranslate.presentation.presenters.interfaces.ui.list.TranslationsView
import javax.inject.Inject

class TranslationsAdapter constructor(
    private val presenter: TranslationsListPresenter
) : RecyclerView.Adapter<TranslationsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TranslationsViewHolder =
        TranslationsViewHolder.create(parent)

    override fun onBindViewHolder(holder: TranslationsViewHolder, position: Int) =
        presenter.bindView(holder)

    override fun getItemCount(): Int = presenter.getCount()
}

class TranslationsViewHolder(private val vb: TranslationsItemBinding) :
    RecyclerView.ViewHolder(vb.root), TranslationsView {

    override fun setTranslations(translations: String) {
        vb.translationsTextView.text = translations
    }

    override fun position(): Int = adapterPosition

    companion object {
        fun create(parent: ViewGroup) = TranslationsViewHolder(
            TranslationsItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
}