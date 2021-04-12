package com.bhd.facilitiesmaintain.data

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * 作者　: hegaojian
 * 时间　: 2019/12/23
 * 描述　: 账户信息
 */


class UserInfo : ArrayList<UserInfoItem>()

@SuppressLint("ParcelCreator")
@Parcelize
data class UserInfoItem(
    val CreateTime: String,
    val Email: String,
    val ID: String,
    val LastLoginTime: String,
    val LastUpdateTime: String,
    val MobileNo: String,
    val RealName: String,
    val Sex: String,
    val UserType: String,
    val WechatNo: String
) : Parcelable