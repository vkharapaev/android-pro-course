package com.headmostlab.justtranslate.presentation.ui.fragments

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.headmostlab.findmovie2.ui.utils.viewBinding
import com.headmostlab.justtranslate.R
import com.headmostlab.justtranslate.databinding.FragmentDictionaryBinding
import com.headmostlab.justtranslate.domain.interactors.interfaces.presenters.DictionaryPresenter
import com.headmostlab.justtranslate.presentation.presenters.interfaces.ui.DictionaryView
import com.headmostlab.justtranslate.presentation.ui.TranslationsAdapter
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DictionaryFragment : Fragment(R.layout.fragment_dictionary), HasAndroidInjector,
    DictionaryView {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var presenter: DictionaryPresenter

    private val binding by viewBinding(FragmentDictionaryBinding::bind)

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.translationsList.apply {
            adapter = TranslationsAdapter(presenter.getTranslationsListPresenter())
        }
        binding.wordEditText.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) =
                presenter.search(p0.toString())

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
            override fun afterTextChanged(p0: Editable?) = Unit
        })
        presenter.attachView(this)
    }

    override fun onDestroyView() {
        presenter.detachView()
        super.onDestroyView()
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun updateTranslationsList() {
        binding.translationsList.adapter?.notifyDataSetChanged()
    }
}