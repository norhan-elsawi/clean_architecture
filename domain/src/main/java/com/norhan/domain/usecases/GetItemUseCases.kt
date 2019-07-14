package com.norhan.domain.usecases

import com.norhan.domain.base.BaseUseCase
import com.norhan.domain.entities.ItemEntity
import com.norhan.domain.executor.PostExecutionThread
import com.norhan.domain.executor.ThreadExecutor
import com.norhan.domain.repositories.HomeRepository
import io.reactivex.Single
import javax.inject.Inject

class GetItemUseCases @Inject constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val homeRepository: HomeRepository
) : BaseUseCase(threadExecutor, postExecutionThread) {

    fun getNews(): Single<List<ItemEntity>> {
        return subscribe(homeRepository.getItems())
    }

}