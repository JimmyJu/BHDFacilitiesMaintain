package com.bhd.facilitiesmaintain.viewmodel.request

import androidx.lifecycle.MutableLiveData
import com.bhd.baselibrary.base.rxjava.BaseObserver
import com.bhd.baselibrary.base.viewmodel.BaseViewModel
import com.bhd.facilitiesmaintain.data.CompanyList
import com.bhd.facilitiesmaintain.data.PositionList
import com.bhd.facilitiesmaintain.network.apiService
import com.blankj.utilcode.util.ToastUtils
import com.google.gson.Gson
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.ResponseBody

class RequestInfoManageViewMode : BaseViewModel() {
    var companyListResult = MutableLiveData<String>()
    var positionListResult = MutableLiveData<String>()

    //获取公司信息
    fun getCompanyList() {
        apiService.getCompanyList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : BaseObserver<ResponseBody>() {
                override fun onFailure(t: ResponseBody?, message: String?) {

                }

                override fun onSuccess(data: ResponseBody?) {
                    val a = data!!.string().replace("\\", "")
                    val b = a.substring(1, a.length - 1)
                    companyListResult.value = b
//                    companyListResult.value = (Gson().fromJson(b, CompanyList::class.java))

                }

            })
    }


    //获取职位信息
    fun getPositionList() {
        apiService.getPositionList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : BaseObserver<ResponseBody>() {
                override fun onFailure(t: ResponseBody?, message: String?) {

                }

                override fun onSuccess(data: ResponseBody?) {
                    val a = data!!.string().replace("\\", "")
                    val b = a.substring(1, a.length - 1)
                    positionListResult.value = b
//                    positionListResult.value = (Gson().fromJson(b,PositionList::class.java))
                }

            })
    }
}