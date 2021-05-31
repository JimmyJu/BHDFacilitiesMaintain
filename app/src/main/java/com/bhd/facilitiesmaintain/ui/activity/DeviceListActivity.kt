package com.bhd.facilitiesmaintain.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.data.DevicesType
import com.bhd.facilitiesmaintain.databinding.ActivityDeviceListBinding
import com.bhd.facilitiesmaintain.ext.getJSONType
import com.bhd.facilitiesmaintain.ext.initClose
import com.bhd.facilitiesmaintain.viewmodel.request.RequestDeviceListViewMode
import com.bhd.facilitiesmaintain.viewmodel.state.DeviceListViewModel
import com.blankj.utilcode.util.ToastUtils
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_device_list.*
import kotlinx.android.synthetic.main.include_toolbar.*

class DeviceListActivity : BaseActivity<DeviceListViewModel,ActivityDeviceListBinding>() {
    private val requestDeviceListViewMode : RequestDeviceListViewMode by viewModels()

    override fun layoutId(): Int {
        return R.layout.activity_device_list
    }

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.vm = mViewModel
        mDatabind.click = ProxyClick()

        var devicesDataset = ArrayList<String>()
        site_name_spinner.setBackgroundResource(R.drawable.shape_spinner)
        device_type_spinner.setBackgroundResource(R.drawable.shape_spinner)
        current_state_spinner.setBackgroundResource(R.drawable.shape_spinner)
        //状态栏显示内容变成黑色
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        toolbar.initClose("产品设备列表") {
            finish()
        }


        //获取设备类型
        requestDeviceListViewMode.getDeviceTypeList()
        requestDeviceListViewMode.devicesTypeResult.observe(this, {
            if (getJSONType(it)) {
                val fromJson = Gson().fromJson(it, DevicesType::class.java)
                for (devicesTypeItem in fromJson) {
                    devicesDataset.add(devicesTypeItem.TypeName)
                }
                device_type_spinner.attachDataSource(devicesDataset)
            } else {
                ToastUtils.showShort(it)
            }
        })

        //设备状态
        val devicesState = arrayListOf("全部","正常","已报修")
        current_state_spinner.attachDataSource(devicesState)

    }
    inner class ProxyClick {
        fun signout() {

        }
        fun query() {

        }

    }
}