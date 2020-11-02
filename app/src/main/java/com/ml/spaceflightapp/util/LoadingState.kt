package com.ml.spaceflightapp.util

/**
 * Class is used by ViewModels to report the changes in  an API call's loading status
 */
data class LoadingState (val status: Status, val message:String? = null){

    companion object {
        val LOADED = LoadingState(Status.SUCCESS)
        val LOADING = LoadingState(Status.RUNNING)

        fun logError(message: String?) = LoadingState(Status.FAILED, message)
    }
    enum class Status{
        RUNNING,
        SUCCESS,
        FAILED
    }
}