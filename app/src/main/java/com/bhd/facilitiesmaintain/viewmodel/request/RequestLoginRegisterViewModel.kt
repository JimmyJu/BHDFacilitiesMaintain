package com.bhd.facilitiesmaintain.viewmodel.request

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.bhd.baselibrary.base.rxjava.BaseObserver
import com.bhd.baselibrary.base.rxjava.NetScheduler
import com.bhd.baselibrary.base.viewmodel.BaseViewModel
import com.bhd.facilitiesmaintain.data.UserInfo
import com.bhd.facilitiesmaintain.network.apiService
import com.google.gson.Gson
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
    var loginResult = MutableLiveData<UserInfo>()

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
                    Log.e("TAG", "onSuccess: $b")
                    loginResult.value = (Gson().fromJson(b, UserInfo::class.java))
                }


            })
    }

    fun <T> fromToJson(json: String, listType: Type) {
        var gson: Gson? = Gson()

    }


//    public <T> T fromToJson(String json,Type listType){
//        Gson gson = new Gson();
//        T t = null;
//        t = gson.fromJson(json,listType);
//        return t;
//    }
}