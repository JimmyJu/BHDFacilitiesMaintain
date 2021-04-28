package com.bhd.facilitiesmaintain.ui.activity


import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation

import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.databinding.ActivityRegisterBinding
import com.bhd.facilitiesmaintain.ext.initClose
import com.bhd.facilitiesmaintain.viewmodel.state.LoginRegisterViewModel

import kotlinx.android.synthetic.main.include_toolbar.*

class RegisterActivity : BaseActivity<LoginRegisterViewModel, ActivityRegisterBinding>() {

    override fun layoutId(): Int {
        return R.layout.activity_register
    }

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.viewmodel = mViewModel
        mDatabind.click = ProxyClick()
        toolbar.initClose("用户注册") {
            finish()
        }
    }

    inner class ProxyClick {
        fun register() {

        }
    }
}