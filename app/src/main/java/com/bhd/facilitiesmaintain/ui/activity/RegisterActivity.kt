package com.bhd.facilitiesmaintain.ui.activity


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.viewModels
import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.data.CompanyList
import com.bhd.facilitiesmaintain.data.PositionList
import com.bhd.facilitiesmaintain.databinding.ActivityRegisterBinding
import com.bhd.facilitiesmaintain.ext.getJSONType
import com.bhd.facilitiesmaintain.ext.hideSoftKeyboard
import com.bhd.facilitiesmaintain.ext.initClose
import com.bhd.facilitiesmaintain.ext.showMessage
import com.bhd.facilitiesmaintain.viewmodel.request.RequestInfoManageViewMode
import com.bhd.facilitiesmaintain.viewmodel.request.RequestLoginRegisterViewModel
import com.bhd.facilitiesmaintain.viewmodel.state.LoginRegisterViewModel
import com.blankj.utilcode.util.RegexUtils
import com.blankj.utilcode.util.ToastUtils
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.company_spinner
import kotlinx.android.synthetic.main.activity_register.position_spinner
import kotlinx.android.synthetic.main.fragment_info_editor.*
import kotlinx.android.synthetic.main.include_toolbar.*


class RegisterActivity : BaseActivity<LoginRegisterViewModel, ActivityRegisterBinding>() {
    private val requestLoginRegisterViewModel: RequestLoginRegisterViewModel by viewModels()
    private val requestInfoManageViewMode: RequestInfoManageViewMode by viewModels()
    var sex: String? = null
    var userType: String? = null
    override fun layoutId(): Int {
        return R.layout.activity_register
    }

    override fun initView(savedInstanceState: Bundle?) {
        addLoadingObserve(requestLoginRegisterViewModel)
        //状态栏显示字体内容颜s
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)

        mDatabind.viewmodel = mViewModel
        mDatabind.click = ProxyClick()

        val companyDataset = ArrayList<String>()
        val positionDataset = ArrayList<String>()

        //设置背景
        company_spinner.setBackgroundResource(R.drawable.shape_spinner)
        position_spinner.setBackgroundResource(R.drawable.shape_spinner)

        toolbar.initClose("用户注册") {
            finish()
        }
        hideSoftKeyboard(this)


        //获取公司
        requestInfoManageViewMode.getCompanyList()
        requestInfoManageViewMode.companyListResult.observe(this, {
            if (getJSONType(it)) {
                val fromJson = Gson().fromJson(it, CompanyList::class.java)
                for (companyListItem in fromJson) {
                    Log.e("TAG", "initView: $companyListItem")
                    companyDataset.add(companyListItem.CompanyName)
                }
                company_spinner.attachDataSource(companyDataset)
            } else {
                ToastUtils.showShort(it)
            }

        })

        //获取职位
        requestInfoManageViewMode.getPositionList()
        requestInfoManageViewMode.positionListResult.observe(this, {

            if (getJSONType(it)) {
                val fromJson = Gson().fromJson(it, PositionList::class.java)
                for (positionListItem in fromJson) {
                    positionDataset.add(positionListItem.PositionName)
                }
                position_spinner.attachDataSource(positionDataset)
            } else {
                ToastUtils.showShort(it)
            }
        })

        mDatabind.boy.setOnClickListener {

            if (mDatabind.boy.isClickable) {
                mDatabind.boy.isEnabled = false
                mDatabind.girl.isEnabled = true
                sex = "男"
            }

        }

        mDatabind.girl.setOnClickListener {
            if (mDatabind.girl.isClickable) {
                mDatabind.girl.isEnabled = false
                mDatabind.boy.isEnabled = true
                sex = "女"
            }
        }

        mDatabind.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            userType = when (checkedId) {
                R.id.radio_admin -> "1"
                R.id.radio_user -> "2"
                else -> null
            }
        }


        //
        requestLoginRegisterViewModel.loginResult.observe(this, {

        })

    }

    inner class ProxyClick {
        /**清空*/
        fun clear() {
            mViewModel.edLoginMobile.set("")
        }


        fun register() {
            Log.e("TAG", "register: " + sex + userType)
            when {
                mViewModel.edLoginMobile.get().isEmpty() -> showMessage("请填写手机号")
                !RegexUtils.isMobileExact(mViewModel.edLoginMobile.get()) -> showMessage("请输入正确的手机号码")
                mViewModel.edLoginPassword.get().isEmpty() -> showMessage("请填写密码")
                mViewModel.edLoginPassword2.get().isEmpty() -> showMessage("请填写确认密码")
                mViewModel.edLoginPassword.get().length < 6 -> showMessage("密码最少6位")
                mViewModel.edLoginPassword.get() != mViewModel.edLoginPassword2.get() -> showMessage(
                    "密码不一致"
                )
                mViewModel.username.get().isEmpty() -> showMessage("请填写姓名")
                sex.isNullOrEmpty() -> showMessage("请选择性别")
                mViewModel.email.get().isEmpty() -> showMessage("请填写邮箱")
                !RegexUtils.isEmail(mViewModel.email.get()) -> showMessage("邮箱格式不正确")
                userType.isNullOrEmpty() -> showMessage("请选择用户类别")
//                else -> requestLoginRegisterViewModel.register(
//                    mViewModel.edLoginMobile.get(),
//                    "",
//                    "",
//                    mViewModel.edLoginPassword.get(),
//                    mViewModel.username.get(),
//                    "",
//                    sex!!,
//                    mViewModel.email.get(),
//                    arrayOf("1"),
//                    arrayOf("1","2")
//                )
            }
        }


        var onCheckedChangeListener1 = CompoundButton.OnCheckedChangeListener { _, isChecked ->
            mViewModel.isShowPwd.set(isChecked)
        }
        var onCheckedChangeListener2 = CompoundButton.OnCheckedChangeListener { _, isChecked ->
            mViewModel.isShowPwd2.set(isChecked)
        }
    }
}