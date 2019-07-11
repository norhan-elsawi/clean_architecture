package com.norhan.cleanarchitecturedemo.base

/**
 * A generic wrapper class around data request
 */
data class Data<T>(var responseType: Status, var data: T? = null, var error: Error? = null)

enum class Status { SUCCESSFUL, ERROR, LOADING }