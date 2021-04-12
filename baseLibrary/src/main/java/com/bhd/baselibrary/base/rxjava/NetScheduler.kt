package com.bhd.baselibrary.base.rxjava


import androidx.lifecycle.LifecycleOwner
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.ObservableTransformer
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit


object NetScheduler {

    fun <T> compose(lifecycleOwner: LifecycleOwner): ObservableTransformer<T, T> {

        return ObservableTransformer { observable ->
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .bindToLifecycle(lifecycleOwner)//绑定生命周期
                .debounce(1, TimeUnit.SECONDS)//防止1s内重复请求
                .debounce(1, TimeUnit.SECONDS)//防止1s内重复请求
        }
    }
}
