package com.bhd.facilitiesmaintain.viewmodel.request

import androidx.lifecycle.MutableLiveData
import com.bhd.baselibrary.base.rxjava.BaseObserver
import com.bhd.baselibrary.base.viewmodel.BaseViewModel
import com.bhd.facilitiesmaintain.data.DevicesType
import com.bhd.facilitiesmaintain.network.apiService
import com.google.gson.Gson
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.ResponseBody

class RequestDeviceListViewMode : BaseViewModel() {

    var devicesTypeResult = MutableLiveData<String>()

    //获取设备类型
    fun getDeviceTypeList() {
        apiService.getDeviceTypeList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : BaseObserver<ResponseBody>() {
                override fun onFailure(t: ResponseBody?, message: String?) {
                    TODO("Not yet implemented")
                }

                override fun onSuccess(data: ResponseBody?) {
                    val a = data!!.string().replace("\\", "")
                    val b = a.substring(1, a.length - 1)
                    devicesTypeResult.value = b
//                    devicesTypeResult.value = (Gson().fromJson(b,DevicesType::class.java))
                }

            })
    }
}