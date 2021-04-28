package com.bhd.facilitiesmaintain.util

import com.bhd.facilitiesmaintain.App
import q.rorbin.badgeview.QBadgeView

class Badgetor() {
    companion object {
        private var badgeView: QBadgeView? = null

        fun getInstance(): QBadgeView {
            if (badgeView == null) {
                badgeView = QBadgeView(App.getContext())
            }
            return badgeView!!
        }
    }
}