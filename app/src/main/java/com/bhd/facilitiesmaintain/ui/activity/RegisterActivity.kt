package com.bhd.facilitiesmaintain.ui.activity

import android.os.Bundle
import android.view.View
import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.databinding.ActivityRegisterBinding
import com.bhd.facilitiesmaintain.viewmodel.state.LoginRegisterViewModel
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity<LoginRegisterViewModel, ActivityRegisterBinding>() {

    override fun layoutId(): Int {
        return R.layout.activity_register
    }

    override fun initView(savedInstanceState: Bundle?) {
        rx_title.setOnClickListener(View.OnClickListener { finish() })
        mDatabind.viewmodel = mViewModel
        mDatabind.click = ProxyClick()

    }

    inner class ProxyClick {
        fun register() {

        }
    }
}