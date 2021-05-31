package com.bhd.facilitiesmaintain.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.databinding.ActivityInforManageBinding
import com.bhd.facilitiesmaintain.ext.initClose
import com.bhd.facilitiesmaintain.ext.initMain
import com.bhd.facilitiesmaintain.viewmodel.state.InfoManageViewModel
import kotlinx.android.synthetic.main.activity_infor_manage.*
import kotlinx.android.synthetic.main.include_toolbar.*

class InforManageActivity : BaseActivity<InfoManageViewModel, ActivityInforManageBinding>() {

    override fun layoutId(): Int {
        return R.layout.activity_infor_manage
    }

    override fun initView(savedInstanceState: Bundle?) {
        //把状态栏显示内容变成黑色
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        mDatabind.vm = mViewModel
        mDatabind.click = ProxyClick()

        toolbar.initClose("用户信息管理") {
            finish()
        }
        mainViewpager.initMain(this)
    }


    inner class ProxyClick {
        fun infoEdit() {
            mainViewpager.setCurrentItem(0,false)
            mDatabind.btnInfoEdit.setTextColor(Color.rgb(2, 87, 160))
            mDatabind.btnChangePws.setTextColor(Color.rgb(119, 119, 119))

        }

        fun changePws() {
            mainViewpager.setCurrentItem(1,false)
            mDatabind.btnInfoEdit.setTextColor(Color.rgb(119, 119, 119))
            mDatabind.btnChangePws.setTextColor(Color.rgb(2, 87, 160))
        }

    }
}