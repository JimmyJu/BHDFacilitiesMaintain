package com.bhd.facilitiesmaintain.ui.fragmeng

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.data.CompanyList
import com.bhd.facilitiesmaintain.data.PositionList
import com.bhd.facilitiesmaintain.databinding.FragmentInfoEditorBinding
import com.bhd.facilitiesmaintain.ext.getJSONType
import com.bhd.facilitiesmaintain.ext.getMap
import com.bhd.facilitiesmaintain.viewmodel.request.RequestInfoManageViewMode
import com.bhd.facilitiesmaintain.viewmodel.state.InfoEditorViewModel
import com.blankj.utilcode.util.ToastUtils
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_infor_manage.*
import kotlinx.android.synthetic.main.fragment_info_editor.*
import org.json.JSONArray


class InfoeEditorFragment : BaseFragment<InfoEditorViewModel, FragmentInfoEditorBinding>() {
    var sex: String? = null
    val companyMap = mutableMapOf<String, String>()
    val positionMap = mutableMapOf<String, String>()
    private val requestInfoManageViewMode: RequestInfoManageViewMode by viewModels()
    override fun layoutId(): Int {
        return R.layout.fragment_info_editor
    }

    override fun initView(savedInstanceState: Bundle?) {
        val companyDataset = ArrayList<String>()
        val positionDataset = ArrayList<String>()

        mDatabind.vm = mViewModel
        mDatabind.click = ProxyClick()

        company_spinner.setBackgroundResource(R.drawable.shape_spinner)
        position_spinner.setBackgroundResource(R.drawable.shape_spinner)


        //获取公司
        requestInfoManageViewMode.getCompanyList()
        requestInfoManageViewMode.companyListResult.observe(this, {
            if (getJSONType(it)) {
                val fromJson = Gson().fromJson(it, CompanyList::class.java)
                for (companyListItem in fromJson) {
                    Log.e("TAG", "initView: $companyListItem")
                    companyDataset.add(companyListItem.CompanyName)
                    companyMap.put(companyListItem.CompanyName, companyListItem.ID)
                }
                company_spinner.attachDataSource(companyDataset.sorted())
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
                    Log.e("TAG", "initView: $positionListItem")
                    positionDataset.add(positionListItem.PositionName)
                    positionMap.put(positionListItem.PositionName, positionListItem.ID)
                }
                position_spinner.attachDataSource(positionDataset.sorted())
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
    }

    inner class ProxyClick {
        fun signout() {

        }

        fun save() {
            val text = company_spinner.text
//            val companyId = text.substring(0, text.indexOf(":"))
            val text1 = position_spinner.text
//            val positionId = text1.substring(0, text1.indexOf(":"))
//            val temp = arrayOf(companyId,positionId)


            Log.e(
                "TAG",
                "save: " + "->公司：" + companyMap.get(company_spinner.text.toString()) + " ->职位：" + positionMap.get(
                    position_spinner.text.toString()
                ) +
                        " ->姓名：" + mViewModel.newUserName.get() + " ->性别：" + sex
            )
        }
    }

    override fun onResume() {
        super.onResume()
        activity?.btn_info_edit?.setTextColor(Color.rgb(2, 87, 160))
        mActivity.btn_change_pws.setTextColor(Color.rgb(119, 119, 119))


    }

}


fun main(args: Array<String>) {

    val positionDataset = ArrayList<String>()
    val mutableMap = mutableMapOf<String, String>()

    var json =
        "[{\"ID\":\"4\",\"PositionName\":\"技术总监\",\"Memo\":\"\"},{\"ID\":\"3\",\"PositionName\":\"软件工程师\",\"Memo\":\"\"},{\"ID\":\"2\",\"PositionName\":\"设备主管\",\"Memo\":\"\"},{\"ID\":\"1\",\"PositionName\":\"硬件工程师\",\"Memo\":\"\"}]"
    if (getJSONType(json)) {
        val fromJson = Gson().fromJson(json, PositionList::class.java)
        for (positionListItem in fromJson) {
            positionDataset.add(positionListItem.PositionName)
            mutableMap.put(positionListItem.ID, positionListItem.PositionName)
            System.out.println(positionListItem.ID + ": " + positionListItem.PositionName)
        }

//        val temp = arrayOf("1", "2", "3")
//        System.out.println("====" + temp[2])

        for (s in positionDataset.sorted()) {
            System.out.println("----" + s)
        }

        for (key in mutableMap.toSortedMap().keys) {
            println(key + "->" + mutableMap[key])
        }
//        println(mutableMap.get("软件工程师"))
    }
}