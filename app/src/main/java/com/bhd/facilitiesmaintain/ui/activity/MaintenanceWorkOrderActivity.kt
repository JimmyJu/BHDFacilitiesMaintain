package com.bhd.facilitiesmaintain.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.databinding.ActivityMaintenanceWorkOrderMainBinding
import com.bhd.facilitiesmaintain.ext.initClose
import com.bhd.facilitiesmaintain.viewmodel.state.MaintenanceWorkOrderViewModel
import kotlinx.android.synthetic.main.include_toolbar.*

class MaintenanceWorkOrderActivity :
    BaseActivity<MaintenanceWorkOrderViewModel, ActivityMaintenanceWorkOrderMainBinding>() {
    override fun layoutId(): Int {
        return R.layout.activity_maintenance_work_order_main
    }

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.vm = mViewModel
        mDatabind.click = ProxyClick()
        //状态栏显示内容变成黑色
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        toolbar.initClose("我的维保工单") {
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