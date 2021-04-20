package com.bhd.facilitiesmaintain.ui.activity

import android.os.Bundle
import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.databinding.ActivityMainBinding
import com.bhd.facilitiesmaintain.viewmodel.state.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {


    override fun layoutId() = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.viewmodel = mViewModel
        mDatabind.click = ProxyClick()
    }

    inner class ProxyClick {
        fun signout() {

        }

        //信息管理
        fun inforManage() {

        }

        //设备列表
        fun deviceList() {

        }

        //工单查询
        fun workOrderQuery() {

        }

        //报修录入
        fun repairEntry() {

        }

        //维护保养
        fun maintenance() {

        }
    }
}
