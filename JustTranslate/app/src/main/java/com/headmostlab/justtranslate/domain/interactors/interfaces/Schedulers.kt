package com.headmostlab.justtranslate.domain.interactors.interfaces

import io.reactivex.rxjava3.core.Scheduler

interface Schedulers {
    fun io(): Scheduler
    fun ui(): Scheduler
}