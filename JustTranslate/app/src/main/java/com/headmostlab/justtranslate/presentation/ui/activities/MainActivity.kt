package com.headmostlab.justtranslate.presentation.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.headmostlab.justtranslate.R
import com.headmostlab.justtranslate.presentation.ui.fragments.DictionaryFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DictionaryFragment())
                .commitNow()
        }
    }
}