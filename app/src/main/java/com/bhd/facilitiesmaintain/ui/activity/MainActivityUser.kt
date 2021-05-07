package com.bhd.facilitiesmaintain.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.databinding.ActivityMainUserBinding
import com.bhd.facilitiesmaintain.viewmodel.state.MainViewModel

//业主
class MainActivityUser : BaseActivity<MainViewModel, ActivityMainUserBinding>() {
    override fun layoutId(): Int {
        return R.layout.activity_main_user
    }

    override fun initView(savedInstanceState: Bundle?) {
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        mDatabind.viewmodel = mViewModel
        mDatabind.click = ProxyClick()
    }

    inner class ProxyClick {
        fun signout() {

        }

        fun inforManage() {

        }

        fun repairManage() {

        }

    }

}