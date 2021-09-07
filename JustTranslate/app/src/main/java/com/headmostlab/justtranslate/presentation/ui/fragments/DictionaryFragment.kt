package com.headmostlab.justtranslate.presentation.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import com.headmostlab.findmovie2.ui.utils.viewBinding
import com.headmostlab.justtranslate.R
import com.headmostlab.justtranslate.databinding.FragmentDictionaryBinding
import com.headmostlab.justtranslate.presentation.presenters.DictionaryViewModelImpl
import com.headmostlab.justtranslate.presentation.ui.adapters.TranslationsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class DictionaryFragment : Fragment(R.layout.fragment_dictionary) {

    private val vm: DictionaryViewModelImpl by viewModel()

    private val binding by viewBinding(FragmentDictionaryBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.translationsList.adapter = TranslationsAdapter()

        binding.wordEditText.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(word: CharSequence?, p1: Int, p2: Int, p3: Int) {
                vm.search(word.toString()).observe(viewLifecycleOwner) {
                    (binding.translationsList.adapter as? TranslationsAdapter)?.setData(it)
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
            override fun afterTextChanged(p0: Editable?) = Unit
        })
    }
}