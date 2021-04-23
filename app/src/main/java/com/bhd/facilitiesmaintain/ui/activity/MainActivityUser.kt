package com.bhd.facilitiesmaintain.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.databinding.ActivityMainUserBinding
import com.bhd.facilitiesmaintain.viewmodel.state.MainViewModel

class MainActivityUser : BaseActivity<MainViewModel, ActivityMainUserBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main_user)
    }

    override fun layoutId(): Int {
        return R.layout.activity_main_user
    }

    override fun initView(savedInstanceState: Bundle?) {
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