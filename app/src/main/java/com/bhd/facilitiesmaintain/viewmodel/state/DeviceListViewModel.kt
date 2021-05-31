package com.bhd.facilitiesmaintain.viewmodel.state

import com.bhd.baselibrary.base.viewmodel.BaseViewModel
import com.bhd.baselibrary.callbak.StringObservableField

class DeviceListViewModel : BaseViewModel() {
    var userName = StringObservableField()
    var devicesName = StringObservableField()
}