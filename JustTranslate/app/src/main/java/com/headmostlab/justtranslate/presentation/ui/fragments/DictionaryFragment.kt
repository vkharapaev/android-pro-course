package com.headmostlab.justtranslate.presentation.ui.fragments

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.headmostlab.findmovie2.ui.utils.viewBinding
import com.headmostlab.justtranslate.R
import com.headmostlab.justtranslate.databinding.FragmentDictionaryBinding
import com.headmostlab.justtranslate.domain.interactors.interfaces.presenters.DictionaryViewModel
import com.headmostlab.justtranslate.presentation.presenters.DictionaryViewModelImpl
import com.headmostlab.justtranslate.presentation.ui.adapters.TranslationsAdapter
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DictionaryFragment : Fragment(R.layout.fragment_dictionary), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: DictionaryViewModel by viewModels<DictionaryViewModelImpl> { viewModelFactory }

    private val binding by viewBinding(FragmentDictionaryBinding::bind)

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.translationsList.adapter = TranslationsAdapter()

        binding.wordEditText.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(word: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.search(word.toString()).observe(viewLifecycleOwner) {
                    (binding.translationsList.adapter as? TranslationsAdapter)?.setData(it)
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
            override fun afterTextChanged(p0: Editable?) = Unit
        })
    }
}