package com.norhan.domain.usecases

import com.norhan.domain.base.BaseUseCase
import com.norhan.domain.executor.PostExecutionThread
import com.norhan.domain.executor.ThreadExecutor
import javax.inject.Inject

class GetItemUseCases @Inject constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : BaseUseCase(threadExecutor, postExecutionThread) {


}