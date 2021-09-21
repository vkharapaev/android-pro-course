package com.headmostlab.justtranslate.presentation.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.headmostlab.justtranslate.R
import com.headmostlab.justtranslate.databinding.FragmentTranslationsDetailBinding
import com.headmostlab.justtranslate.domain.entities.Translations
import com.headmostlab.justtranslate.presentation.ui.utils.viewBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import org.koin.androidx.scope.ScopeFragment

class TranslationsDetailFragment : ScopeFragment(R.layout.fragment_translations_detail) {

    companion object {
        const val TRANSLATIONS = "TRANSLATIONS"
        fun newInstance(translations: Translations): TranslationsDetailFragment {
            return TranslationsDetailFragment().apply {
                arguments = bundleOf(TRANSLATIONS to translations)
            }
        }
    }

    private val binding by viewBinding(FragmentTranslationsDetailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val translations =
            arguments?.getParcelable<Translations>(TRANSLATIONS) ?: throw IllegalAccessException()

        binding.phraseTextView.text = translations.text

        translations.meanings?.elementAtOrNull(0)?.let { meaning ->
            binding.meaningOne.meaning.text = meaning.translation?.text

            val path = "https:${meaning.imageUrl}"
            Picasso.get().load(path).transform(CropCircleTransformation())
                .into(binding.meaningOne.picture)
        }

        translations.meanings?.elementAtOrNull(1)?.let { meaning ->
            binding.meaningTwo.meaning.text = meaning.translation?.text

            val path = "https:${meaning.imageUrl}"
            Picasso.get().load(path).transform(CropCircleTransformation())
                .into(binding.meaningTwo.picture)
        }

    }
}