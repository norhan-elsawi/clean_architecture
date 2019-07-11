package com.norhan.domain.base

import com.norhan.domain.executor.PostExecutionThread
import com.norhan.domain.executor.ThreadExecutor
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

abstract class BaseUseCase constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) {

    fun <T> subscribe(single: Single<T>): Single<T> {
        return single
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler)

    }
}