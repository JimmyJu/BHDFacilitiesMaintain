package com.bhd.facilitiesmaintain.network

import com.bhd.facilitiesmaintain.viewmodel.Response
import com.google.gson.JsonObject
import io.reactivex.rxjava3.core.Observable
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * 作者　: hegaojian
 * 时间　: 2019/12/23
 * 描述　: 网络API
 */
interface ApiService {

    companion object {
        const val SERVER_URL = "https://fms.yinxinht.com/"
    }

    /**
     * 登录
     */
    @POST("user/Login?")
    fun login(
        @Query("MobileNo") MobileNo: String,
        @Query("Password") Password: String
    ): Observable<ResponseBody>


}