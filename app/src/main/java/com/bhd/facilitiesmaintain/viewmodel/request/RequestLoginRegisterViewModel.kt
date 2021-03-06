package com.bhd.facilitiesmaintain.viewmodel.request

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.bhd.baselibrary.base.rxjava.BaseObserver
import com.bhd.baselibrary.base.viewmodel.BaseViewModel
import com.bhd.facilitiesmaintain.data.UserInfo
import com.bhd.facilitiesmaintain.network.apiService
import com.blankj.utilcode.util.ToastUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.ResponseBody
import java.lang.reflect.Type


/**
 * 作者　: hegaojian
 * 时间　: 2019/12/23
 * 描述　:登录注册的请求ViewModel
 */
class RequestLoginRegisterViewModel : BaseViewModel() {
    //    var loginResult = MutableLiveData<UserInfo>()
    var loginResult = MutableLiveData<String>()

    fun loginRequest(username: String, password: String) {

        apiService.login(username, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : BaseObserver<ResponseBody>() {
                override fun onFailure(t: ResponseBody?, message: String?) {
                    Log.e("TAG", "onFailure: " + message)
                }

                override fun onSuccess(data: ResponseBody?) {
                    val a = data!!.string().replace("\\", "")
                    val b = a.substring(1, a.length - 1)
                    loginResult.value = b
//                    loginResult.value = (Gson().fromJson(b, UserInfo::class.java))
                }
            })
    }


    fun register(
        mobileNo: String,
        wechatNo: String,
        openID: String,
        password: String,
        realName: String,
        userType: String,
        sex: String,
        email: String,
        companyIDs : Array<String>,
        positionIDs : Array<String>
    ) {
        apiService.submit(mobileNo,wechatNo,openID,password,realName,userType,sex,email,companyIDs,positionIDs)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : BaseObserver<ResponseBody>() {
                override fun onFailure(t: ResponseBody?, message: String?) {
                    TODO("Not yet implemented")
                }

                override fun onSuccess(data: ResponseBody?) {
                    val a = data!!.string().replace("\\", "")
                    val b = a.substring(1, a.length - 1)
                    loginResult.value = b
                }
            })
    }
}