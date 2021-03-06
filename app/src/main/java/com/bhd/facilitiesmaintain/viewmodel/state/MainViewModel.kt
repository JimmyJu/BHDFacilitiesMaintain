package com.bhd.facilitiesmaintain.viewmodel.state

import com.bhd.baselibrary.base.viewmodel.BaseViewModel
import com.bhd.baselibrary.callbak.StringObservableField

class MainViewModel : BaseViewModel() {
    var promptMessage = StringObservableField()
    var userName = StringObservableField()
}
