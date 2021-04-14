package com.bhd.facilitiesmaintain.ui.activity

import android.os.Bundle
import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.databinding.ActivityRegisterBinding
import com.bhd.facilitiesmaintain.viewmodel.state.LoginRegisterViewModel

class RegisterActivity : BaseActivity<LoginRegisterViewModel, ActivityRegisterBinding>() {

    override fun layoutId(): Int {
        return R.layout.activity_register
    }

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.viewmodel = mViewModel
        mDatabind.click = ProxyClick()

    }

    inner class ProxyClick {
        fun register() {

        }
    }
}