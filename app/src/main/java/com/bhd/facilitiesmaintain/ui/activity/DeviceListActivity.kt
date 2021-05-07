package com.bhd.facilitiesmaintain.ui.activity

import android.os.Bundle
import android.view.View
import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.databinding.ActivityDeviceListBinding
import com.bhd.facilitiesmaintain.ext.initClose
import com.bhd.facilitiesmaintain.viewmodel.state.DeviceListViewModel
import kotlinx.android.synthetic.main.include_toolbar.*

class DeviceListActivity : BaseActivity<DeviceListViewModel,ActivityDeviceListBinding>() {
    override fun layoutId(): Int {
        return R.layout.activity_device_list
    }

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.vm = mViewModel
        mDatabind.click = ProxyClick()
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        toolbar.initClose("产品设备列表") {
            finish()
        }

    }
    inner class ProxyClick {
        fun signout() {

        }
        fun query() {

        }

    }
}