package com.norhan.cleanarchitecturedemo.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<T, M> : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun subscribe(single: Single<T>, data: MutableLiveData<Data<M>>) {
        compositeDisposable.add(single
            .doOnSubscribe {
                data.value = Data(responseType = Status.LOADING)
            }
            .subscribe({ response ->
                data.value = Data(responseType = Status.SUCCESSFUL, data = getMappedResponse(response))
            }, { error ->
                data.value = Data(responseType = Status.ERROR, error = Error(error.message))
            })
        )
    }

    abstract fun getMappedResponse(data: T): M

    private fun clearSubscription() {
        if (compositeDisposable.isDisposed.not()) compositeDisposable.clear()
    }

    override fun onCleared() {
        clearSubscription()
        super.onCleared()
    }
}