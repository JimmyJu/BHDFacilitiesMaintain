package com.bhd.facilitiesmaintain.viewmodel.state

import android.util.Log
import com.bhd.baselibrary.base.viewmodel.BaseViewModel
import com.bhd.baselibrary.callbak.StringObservableField


/**
 * 作者　: hegaojian
 * 时间　: 2019/12/23
 * 描述　:登录注册的ViewModel
 */
class LoginRegisterViewModel : BaseViewModel() {

    //用户名
    var edLoginMobile = StringObservableField()

    //密码(登录注册界面)
    var edLoginPassword = StringObservableField()

    //密码(登录注册界面)
    var password1 = StringObservableField()

    var password2 = StringObservableField()


    fun loginBtnEnabled(): Boolean {
        return true

    }


}