package com.bhd.facilitiesmaintain.ext

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bhd.baselibrary.base.appContext
import com.bhd.facilitiesmaintain.R
import com.bhd.facilitiesmaintain.ui.activity.InforManageActivity
import com.bhd.facilitiesmaintain.ui.fragmeng.ChangePasswordFragment
import com.bhd.facilitiesmaintain.ui.fragmeng.InfoeEditorFragment
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
    backImg: Int = R.mipmap.back,
    onBack: (toolbar: Toolbar) -> Unit
): Toolbar {
    setBackgroundColor(Color.parseColor("#FFFFFF"))
    setTitleTextColor(Color.parseColor("#333333"))
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

/**
 * //初始化viewpager2
 */
fun ViewPager2.initMain(activity: FragmentActivity): ViewPager2 {
    //是否可滑动
    this.isUserInputEnabled = false
    this.offscreenPageLimit = 2
    //设置适配器
    adapter = object : FragmentStateAdapter(activity) {
        override fun createFragment(position: Int): Fragment {
            when (position) {
                0 -> {
                    return InfoeEditorFragment()
                }
                1 -> {
                    return ChangePasswordFragment()
                }
                else -> {
                    return InfoeEditorFragment()
                }
            }
        }
        override fun getItemCount() = 2
    }
    return this
}

/**
 * 扩展函数接收一个动画和一个点击响应逻辑（用lambda表示）
 */
@SuppressLint("ClickableViewAccessibility")
fun View.extraAnimClickListener(animator: ValueAnimator, action: (View) -> Unit) {
    setOnTouchListener { v, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> animator.start()
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> animator.reverse()
        }
        false
    }
    setOnClickListener { action(this) }
}
