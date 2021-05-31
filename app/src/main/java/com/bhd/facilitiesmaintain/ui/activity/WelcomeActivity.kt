package com.bhd.facilitiesmaintain.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bhd.facilitiesmaintain.R
import com.nineoldandroids.animation.Animator
import com.nineoldandroids.animation.AnimatorListenerAdapter
import com.nineoldandroids.animation.AnimatorSet
import com.nineoldandroids.animation.ObjectAnimator
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        object : Thread() {
            override fun run() {
                super.run()
                try {
                    sleep(2000)
                    runOnUiThread { animateImage() }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }.start()
    }

    fun animateImage() {

        //设置缩放动画
        val animatorX: ObjectAnimator = ObjectAnimator.ofFloat(
            img_splash, "scaleX", 1f,
            1.15f
        )
        val animatorY: ObjectAnimator = ObjectAnimator.ofFloat(
            img_splash, "scaleY", 1f,
            1.15f
        )
        val set = AnimatorSet()
        set.setDuration(2000).play(animatorX).with(animatorY)
        set.start()

        //动画完成监听
        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {

                //动画完成后跳转首页
                startActivity(Intent(this@WelcomeActivity, LoginActivity::class.java))
                finish()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }
        })
    }

}