package com.headmostlab.justtranslate.presentation.ui

import com.headmostlab.justtranslate.domain.interactors.interfaces.Schedulers
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Inject

class AndroidSchedulers @Inject constructor() : Schedulers {
    override fun io(): Scheduler {
        return io.reactivex.rxjava3.schedulers.Schedulers.io()
    }

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}