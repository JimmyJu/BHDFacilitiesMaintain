package com.bhd.facilitiesmaintain

import android.content.Context
import com.bhd.baselibrary.base.BaseApp

class App : BaseApp() {
    companion object {
        var _context: BaseApp? = null
        fun getContext(): Context {
            return _context!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        _context = this
    }
}