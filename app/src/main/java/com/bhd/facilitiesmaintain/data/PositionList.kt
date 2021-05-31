package com.bhd.facilitiesmaintain.data

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * 作者　: hegaojian
 * 时间　: 2019/12/23
 * 描述　: 职位信息
 */


class PositionList : ArrayList<PositionListItem>()

@SuppressLint("ParcelCreator")
@Parcelize
data class PositionListItem(
    var ID: String,
    var PositionName: String,
    var Memo: String
) : Parcelable