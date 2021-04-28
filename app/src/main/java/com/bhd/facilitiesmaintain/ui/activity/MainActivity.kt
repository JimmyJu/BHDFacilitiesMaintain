package com.bhd.facilitiesmaintain.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager

import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.databinding.ActivityMainBinding

import com.bhd.facilitiesmaintain.util.Badgetor
import com.bhd.facilitiesmaintain.viewmodel.state.MainViewModel
import q.rorbin.badgeview.Badge


class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {


    override fun layoutId() = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.viewmodel = mViewModel
        mDatabind.click = ProxyClick()

        var count = Badgetor.getInstance().badgeNumber

        Badgetor.getInstance().setBadgeTextSize(14F, true)
        Badgetor.getInstance().setBadgeTextColor(Color.parseColor("#ffffff"))
        //设置精确数值,只有设置数字的时候才生效,false时当数字大于99时显示99+，true时数字大于99时显示实际数字
        Badgetor.getInstance().setExactMode(true)
        //设置BadgeView相对mTvTest的位置,右上角
        Badgetor.getInstance().setBadgeGravity(Gravity.END or Gravity.TOP)
        Badgetor.getInstance().setGravityOffset(2F, 2f, true)
//        Badgetor.getInstance().setBadgePadding(2F,true)
        Badgetor.getInstance().setBadgeBackgroundColor(Color.parseColor("#ff0000"))
        Badgetor.getInstance().bindTarget(mDatabind.btnBxgd).setBadgeNumber(12)
        dragState()

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

        //维护工单
        fun maintenanceWorkOrder() {

        }

        //维护工单查询
        fun maintenanceWorkOrderQuery() {

        }

        //报修工单
        fun repairWorkOrder() {

        }

        //报修工单查询
        fun repairWorkOrderQuery() {

        }

        //报修录入
        fun repairEntry() {

        }
    }

    fun dragState() {
        Badgetor.getInstance()
            .setOnDragStateChangedListener(object : Badge.OnDragStateChangedListener {
                override fun onDragStateChanged(
                    dragState: Int,
                    badge: Badge?,
                    targetView: View?
                ) {

                }

            })
    }
}
