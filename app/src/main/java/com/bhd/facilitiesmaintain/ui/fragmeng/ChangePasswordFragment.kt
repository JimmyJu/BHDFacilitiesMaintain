package com.bhd.facilitiesmaintain.ui.fragmeng

import android.os.Bundle

import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.databinding.FragmentChangePasswordBinding
import com.bhd.facilitiesmaintain.viewmodel.state.ChangePasswordViewModel

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

        }
        fun signout() {

        }
    }
}