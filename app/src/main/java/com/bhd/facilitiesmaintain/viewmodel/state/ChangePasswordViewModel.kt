package com.bhd.facilitiesmaintain.viewmodel.state

import com.bhd.baselibrary.base.viewmodel.BaseViewModel
import com.bhd.baselibrary.callbak.StringObservableField

class ChangePasswordViewModel : BaseViewModel() {
    var userName = StringObservableField()
    var newPswAgain = StringObservableField()
    var newPsw = StringObservableField()
    var originalPsw = StringObservableField()
}