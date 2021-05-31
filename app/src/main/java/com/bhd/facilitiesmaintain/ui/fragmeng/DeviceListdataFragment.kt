package com.bhd.facilitiesmaintain.ui.fragmeng

import android.os.Bundle
import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.databinding.FragmentDeviceListdataBinding
import com.bhd.facilitiesmaintain.viewmodel.state.DeviceListdataViewModel


class DeviceListdataFragment : BaseFragment<DeviceListdataViewModel,FragmentDeviceListdataBinding>() {
    override fun layoutId(): Int {
       return R.layout.fragment_device_listdata
    }

    override fun initView(savedInstanceState: Bundle?) {

    }

}