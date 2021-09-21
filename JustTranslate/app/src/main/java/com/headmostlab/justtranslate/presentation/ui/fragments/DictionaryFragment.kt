package com.headmostlab.justtranslate.presentation.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.headmostlab.justtranslate.R
import com.headmostlab.justtranslate.databinding.FragmentDictionaryBinding
import com.headmostlab.justtranslate.presentation.presenters.DictionaryViewModel
import com.headmostlab.justtranslate.presentation.ui.adapters.TranslationsAdapter
import com.headmostlab.justtranslate.presentation.ui.utils.viewBinding
import org.koin.androidx.scope.ScopeFragment

class DictionaryFragment : ScopeFragment(R.layout.fragment_dictionary) {

    private val vm: DictionaryViewModel by scope.inject()

    private val binding by viewBinding(FragmentDictionaryBinding::bind)

    private val adapter = TranslationsAdapter {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.container, TranslationsDetailFragment.newInstance(it))
            addToBackStack(null)
        }.commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vm.translations.observe(viewLifecycleOwner) { adapter.setData(it) }
        vm.defaultWord.observe(viewLifecycleOwner) { word -> binding.wordEditText.setText(word) }
        binding.translationsList.adapter = adapter
        binding.wordEditText.addTextChangedListener { word -> vm.search(word.toString()) }
    }

}