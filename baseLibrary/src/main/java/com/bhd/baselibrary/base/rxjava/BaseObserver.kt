package com.bhd.baselibrary.base.rxjava

import android.util.Log
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseObserver<T> : Observer<T> {
    private val TAG = "BaseObserver"

    override fun onSubscribe(d: Disposable?) {
        Log.e(TAG, "onSubscribe" + d!!.isDisposed)
    }

    override fun onNext(value: T) {
        onSuccess(value)
    }


    override fun onError(error: Throwable) {
        Log.e(TAG, "onError:" + error.message)
    }

    override fun onComplete() {
        Log.e(TAG, "onComplete")
    }

    abstract fun onFailure(t: T?, message: String?)

    abstract fun onSuccess(data: T?)
}
