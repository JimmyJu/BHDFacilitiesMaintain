package com.bhd.facilitiesmaintain.viewmodel.state

import android.util.Log
import android.view.View
import androidx.databinding.ObservableInt
import com.bhd.baselibrary.base.viewmodel.BaseViewModel
import com.bhd.baselibrary.callbak.BooleanObservableField
import com.bhd.baselibrary.callbak.StringObservableField


/**
 * 作者　: hegaojian
 * 时间　: 2019/12/23
 * 描述　:登录注册的ViewModel
 */
class LoginRegisterViewModel : BaseViewModel() {

    //手机号
    var edLoginMobile = StringObservableField()

    //密码(登录注册界面)
    var edLoginPassword = StringObservableField()

    var edLoginPassword2 = StringObservableField()


    //是否显示明文密码（登录注册界面）
    var isShowPwd = BooleanObservableField()

    var isShowPwd2 = BooleanObservableField()

    //用户名
    var username = StringObservableField()

    //邮箱
    var email = StringObservableField()
    
    fun loginBtnEnabled(): Boolean {
        return true

    }


    //手机号清除按钮是否显示   不要在 xml 中写逻辑 所以逻辑判断放在这里
    var clearVisible = object : ObservableInt(edLoginMobile){
        override fun get(): Int {
            return if(edLoginMobile.get().isEmpty()){
                View.GONE
            }else{
                View.VISIBLE
            }
        }
    }

    //密码显示按钮是否显示   不要在 xml 中写逻辑 所以逻辑判断放在这里
    var passwordVisible = object :ObservableInt(edLoginPassword){
        override fun get(): Int {
            return if(edLoginPassword.get().isEmpty()){
                View.GONE
            }else{
                View.VISIBLE
            }
        }
    }

    //密码显示按钮是否显示   不要在 xml 中写逻辑 所以逻辑判断放在这里
    var passwordVisible2 = object :ObservableInt(edLoginPassword2){
        override fun get(): Int {
            return if(edLoginPassword2.get().isEmpty()){
                View.GONE
            }else{
                View.VISIBLE
            }
        }
    }


}