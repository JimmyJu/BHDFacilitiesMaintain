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
        //正式
//        const val SERVER_URL = "https://fms.yinxinht.com/"
        //测试
        const val SERVER_URL = "http://172.16.1.8:82/"
    }

    /**
     * 登录
     */
    @POST("user/Login?")
    fun login(
        @Query("MobileNo") MobileNo: String,
        @Query("Password") Password: String
    ): Observable<ResponseBody>

    /**
     * 微信号登录
     */
    @POST("user/Login?")
    fun loginWC(
        @Query("WechatNo") WechatNo: String,
        @Query("Password") Password: String
    ): Observable<ResponseBody>

    /**
     * 获取公司信息
     */
    @POST("user/GetCompanyList")
    fun getCompanyList(): Observable<ResponseBody>

    /**
     * 取岗位信息
     */
    @POST("user/GetPositionList")
    fun getPositionList(): Observable<ResponseBody>

    /**
     * 提交注册
     */
    @POST("user/Reg?")
    fun submit(
        @Query("MobileNo") MobileNo: String,
        @Query("WechatNo") WechatNo: String,
        @Query("OpenID") OpenID: String,
        @Query("Password") Password: String,
        @Query("RealName") RealName: String,
        @Query("UserType") UserType: String,
        @Query("Sex") Sex: String,
        @Query("Email") Email: String,
        @Query("CompanyIDs") CompanyIDs: Array<String>,
        @Query("PositionIDs") PositionIDs: Array<String>
    ): Observable<ResponseBody>

    /**
     * 产品设备列表--获取公司名称
     */
    @POST("Repair/GetCompanyList?")
    fun getCompanyList(
        @Query("UserInfoID") UserInfoID: String
    ): Observable<ResponseBody>

    /**
     * 产品设备列表--获取设备类型
     */
    @POST("Repair/GetDeviceTypeList")
    fun getDeviceTypeList(): Observable<ResponseBody>

    /**
     * 产品设备列表--查询获取设备列表信息
     */
    @POST("Repair/GetDeviceInfoList?")
    fun getDeviceInfoList(
        @Query("UserInfoID") UserInfoID: String,
        @Query("CompanyID") CompanyID: String,
        @Query("Status") Status: String,
        @Query("DeviceTypeID") DeviceTypeID: String,
        @Query("DeviceName") DeviceName: String
    ): Observable<ResponseBody>

}