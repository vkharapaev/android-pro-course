package com.headmostlab.justtranslate.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.shape.RoundedCornerTreatment
import com.headmostlab.justtranslate.databinding.MeaningItemBinding
import com.headmostlab.justtranslate.databinding.TranslationsItemBinding
import com.headmostlab.justtranslate.domain.entities.Meaning
import com.headmostlab.justtranslate.domain.entities.Translations
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation

class TranslationsAdapter : RecyclerView.Adapter<TranslationsViewHolder>() {

    private val data = mutableListOf<Translations>()

    fun setData(translations: List<Translations>) {
        data.clear()
        data.addAll(translations)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TranslationsViewHolder =
        TranslationsViewHolder.create(parent)

    override fun onBindViewHolder(holder: TranslationsViewHolder, position: Int) =
        holder.bind(data[position])

    override fun getItemCount(): Int = data.size
}

class TranslationsViewHolder(private val vb: TranslationsItemBinding) :
    RecyclerView.ViewHolder(vb.root) {

    fun bind(translations: Translations) {
        vb.phraseTextView.text = translations.text
        translations.meanings?.elementAtOrNull(0).let { renderMeaning(it, vb.meaningOne) }
        translations.meanings?.elementAtOrNull(1).let { renderMeaning(it, vb.meaningTwo) }
    }

    private fun renderMeaning(meaning: Meaning?, vb: MeaningItemBinding) {
        if (meaning == null) {
            vb.meaningContainer.visibility = View.GONE
        } else {
            vb.meaningContainer.visibility = View.VISIBLE
            if (meaning.imageUrl != null && meaning.imageUrl.isNotEmpty()) {
                val path = "https:${meaning.imageUrl}"
                Picasso.get().load(path).transform(CropCircleTransformation()).into(vb.picture)
            }
            vb.meaning.text = meaning.translation?.text
        }
    }

    companion object {
        fun create(parent: ViewGroup) = TranslationsViewHolder(
            TranslationsItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
}