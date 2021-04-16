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
    var CreateTime: String,
    var Email: String,
    var ID: String,
    var LastLoginTime: String,
    var LastUpdateTime: String,
    var MobileNo: String,
    var RealName: String,
    var Sex: String,
    var UserType: String,
    var WechatNo: String
) : Parcelable