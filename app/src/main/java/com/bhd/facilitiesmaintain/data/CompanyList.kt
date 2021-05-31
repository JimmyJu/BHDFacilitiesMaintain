package com.bhd.facilitiesmaintain.data

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * 作者　: hegaojian
 * 时间　: 2019/12/23
 * 描述　: 公司信息
 */


class CompanyList : ArrayList<CompanyListItem>()

@SuppressLint("ParcelCreator")
@Parcelize
data class CompanyListItem(
    var ID: String,
    var CompanyName: String,
    var Memo: String
) : Parcelable