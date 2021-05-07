package com.bhd.facilitiesmaintain.ui.fragmeng

import android.os.Bundle
import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.databinding.FragmentInfoEditorBinding
import com.bhd.facilitiesmaintain.viewmodel.state.InfoEditorViewModel


class InfoeEditorFragment : BaseFragment<InfoEditorViewModel, FragmentInfoEditorBinding>() {
    override fun layoutId(): Int {
        return R.layout.fragment_info_editor
    }

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.vm = mViewModel
        mDatabind.click = ProxyClick()
    }


    inner class ProxyClick {
        fun signout() {

        }

        fun save() {

        }
    }

}