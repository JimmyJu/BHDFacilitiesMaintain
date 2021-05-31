package com.bhd.facilitiesmaintain.ui.fragmeng

import android.graphics.Color
import android.os.Bundle

import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.databinding.FragmentChangePasswordBinding
import com.bhd.facilitiesmaintain.ext.showMessage
import com.bhd.facilitiesmaintain.viewmodel.state.ChangePasswordViewModel
import kotlinx.android.synthetic.main.activity_infor_manage.*

class ChangePasswordFragment : BaseFragment<ChangePasswordViewModel,FragmentChangePasswordBinding>() {
    override fun layoutId(): Int {
        return R.layout.fragment_change_password
    }

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.vm = mViewModel
        mDatabind.click = ProxyClick()
    }

    inner class ProxyClick {


        fun Confirm() {
            when{
                mViewModel.originalPsw.get().isEmpty() -> showMessage("请输入原始密码")
                mViewModel.newPsw.get().isEmpty() -> showMessage("请输入新密码")
                mViewModel.newPswAgain.get().isEmpty() -> showMessage("请再次输入新密码")
                (! mViewModel.newPsw.get().equals(mViewModel.newPswAgain.get())) -> showMessage("两次输入的新密码不一致")
                else -> {

                }
            }
        }
        fun signout() {

        }
    }

    override fun onResume() {
        super.onResume()
        mActivity.btn_info_edit.setTextColor(Color.rgb(119, 119, 119))
        activity?.btn_change_pws?.setTextColor(Color.rgb(2, 87, 160))
    }
}