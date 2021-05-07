package com.bhd.facilitiesmaintain.ui.activity

import android.os.Bundle
import android.view.View
import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.databinding.ActivityInforManageBinding
import com.bhd.facilitiesmaintain.ext.initClose
import com.bhd.facilitiesmaintain.viewmodel.state.InfoManageViewModel
import kotlinx.android.synthetic.main.activity_infor_manage.*
import kotlinx.android.synthetic.main.include_toolbar.*

class InforManageActivity : BaseActivity<InfoManageViewModel, ActivityInforManageBinding>() {

    override fun layoutId(): Int {
        return R.layout.activity_infor_manage
    }

    override fun initView(savedInstanceState: Bundle?) {
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        mDatabind.vm = mViewModel
        toolbar.initClose("用户信息管理") {
            finish()
        }
        mainBottom.setTextSize(16F)
    }
}