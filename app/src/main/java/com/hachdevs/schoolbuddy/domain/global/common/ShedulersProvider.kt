package com.hachdevs.schoolbuddy.domain.global.common

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

val io: Scheduler
    get() = Schedulers.io()

val ui: Scheduler
    get() = AndroidSchedulers.mainThread()