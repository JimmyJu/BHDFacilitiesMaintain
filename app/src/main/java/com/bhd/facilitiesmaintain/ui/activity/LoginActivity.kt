package com.bhd.facilitiesmaintain.ui.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.databinding.ActivityLoginBinding
import com.bhd.facilitiesmaintain.ext.hideSoftKeyboard
import com.bhd.facilitiesmaintain.viewmodel.request.RequestLoginRegisterViewModel
import com.bhd.facilitiesmaintain.viewmodel.state.LoginRegisterViewModel
import com.blankj.utilcode.util.ToastUtils
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity<LoginRegisterViewModel, ActivityLoginBinding>() {

    private val requestLoginRegisterViewModel: RequestLoginRegisterViewModel by viewModels()

    override fun layoutId(): Int = R.layout.activity_login

    override fun initView(savedInstanceState: Bundle?) {
        addLoadingObserve(requestLoginRegisterViewModel)
        mDatabind.viewmodel = mViewModel
        mDatabind.click = ProxyClick()
        requestLoginRegisterViewModel.loginResult.observe(this, Observer {
            dismissLoading()
            Log.e("TAG", "initView: " + it[0].Email)
            val realName = it[0].RealName
            val userType = it[0].UserType
        })

    }

    inner class ProxyClick {
        fun loginClick() {
            when {
                mViewModel.edLoginMobile.get().isEmpty() -> ToastUtils.showShort("用户名不能为空")
                mViewModel.edLoginPassword.get().isEmpty() -> ToastUtils.showShort("密码不能为空")
                else -> {
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    /*showLoading("请求网络中")
                    requestLoginRegisterViewModel.loginRequest(
                        mViewModel.edLoginMobile.get(),
                        mViewModel.edLoginPassword.get()
                    )*/
                }
            }
        }

        fun goRegister() {
            hideSoftKeyboard(this@LoginActivity)
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
//            startActivity<RegisterActivity>()
        }
    }
}