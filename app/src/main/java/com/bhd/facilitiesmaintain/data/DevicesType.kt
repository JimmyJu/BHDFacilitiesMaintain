package com.bhd.facilitiesmaintain.data

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * 作者　: hegaojian
 * 时间　: 2019/12/23
 * 描述　: 公司信息
 */


class DevicesType : ArrayList<DevicesTypeItem>()

@SuppressLint("ParcelCreator")
@Parcelize
data class DevicesTypeItem(
    val ID: String,
    val TypeName: String
) : Parcelable