package com.norhan.cleanarchitecturedemo.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.norhan.cleanarchitecturedemo.mapper.Mapper
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class BaseViewModel<V, D>(private val mapper: Mapper<V, D>) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun subscribe(single: Single<D>, data: MutableLiveData<Data<V>>) {
        compositeDisposable.add(single
            .doOnSubscribe {
                data.value = Data(responseType = Status.LOADING)
            }
            .subscribe({ response ->
                data.value = Data(responseType = Status.SUCCESSFUL, data = mapper.mapToViewModel(response))
            }, { error ->
                data.value = Data(responseType = Status.ERROR, error = Error(error.message))
            })
        )
    }

    private fun clearSubscription() {
        if (compositeDisposable.isDisposed.not()) compositeDisposable.clear()
    }

    override fun onCleared() {
        clearSubscription()
        super.onCleared()
    }
}