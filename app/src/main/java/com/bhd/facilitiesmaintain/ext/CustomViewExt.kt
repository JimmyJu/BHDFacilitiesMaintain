package com.bhd.facilitiesmaintain.ext

import android.app.Activity
import android.graphics.Color
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.Toolbar
import com.bhd.baselibrary.base.appContext
import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.util.SettingUtil

/**
 * 作者　: hegaojian
 * 时间　: 2020/2/20
 * 描述　:项目中自定义类的拓展函数
 */

/**
 * 初始化有返回键的toolbar
 */
fun Toolbar.initClose(
    titleStr: String = "",
    backImg: Int = R.drawable.previous_icon,
    onBack: (toolbar: Toolbar) -> Unit
): Toolbar {
    setBackgroundColor(SettingUtil.getColor(appContext))
    setTitleTextColor(Color.BLACK)
    title = titleStr.toHtml()
    setNavigationIcon(backImg)
    setNavigationOnClickListener { onBack.invoke(this) }
    return this
}


/**
 * 隐藏软键盘
 */
fun hideSoftKeyboard(activity: Activity?) {
    activity?.let { act ->
        val view = act.currentFocus
        view?.let {
            val inputMethodManager =
                act.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(
                view.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }
}