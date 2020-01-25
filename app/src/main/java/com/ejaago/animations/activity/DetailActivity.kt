package com.ejaago.animations.activity

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.ejaago.animations.fragments.PlayFragment
import com.ejaago.animations.utils.ProgressBarAnimation
import com.ejaago.animations.R
import com.ejaago.animations.utils.toAnimate
import kotlinx.android.synthetic.main.activity_details.*


class DetailActivity : AppCompatActivity() {
    lateinit var hrLinearLayout: LinearLayout
    lateinit var download: Button
    lateinit var progress: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        progress = findViewById(R.id.mf_progress_bar)

        hrLinearLayout = findViewById(R.id.hr_linear_layout)
        download = findViewById(R.id.button)
        addView()

        download.setOnClickListener {
            performDownloadOperation(it)

        }

        play_bottom.setOnClickListener {
            val fragment = PlayFragment()
            val bundle = Bundle()
            fragment.arguments = bundle

            val transaction =
                supportFragmentManager.beginTransaction()
            transaction.add(fragment, "loading")
            transaction.commitAllowingStateLoss()
        }


    }

    private fun performDownloadOperation(it: View) {
        applicationContext.toAnimate(R.anim.fade_out, it)
        it.visibility = View.GONE



        Handler().postDelayed({
            progress_layout.visibility = View.VISIBLE
            applicationContext.toAnimate(R.anim.fade_in, progress_layout)
            applicationContext.toAnimate(R.anim.slide_from_left, float_btn)

            fillProgressBar()
            
            Handler().postDelayed({
                applicationContext.toAnimate(R.anim.fade_out, float_btn)
                float_btn.setImageResource(R.drawable.ic_done_white)
                progress_layout.visibility = View.GONE
                play_bottom.visibility = View.VISIBLE
                applicationContext.toAnimate(R.anim.bottom_up, play_bottom)
            },1000)

        },1000)

    }

    private fun fillProgressBar() {
        val fValue = 0
        var toValue = 0
        for (x in 0..100 step 10) {
            toValue = x
            val anim = ProgressBarAnimation(
                progress,
                fValue,
                toValue
            )
            anim.duration = 1000
            progress.startAnimation(anim)
        }


    }

    private fun addView() {
        for (x in 0..3) {
            val imageView = ImageView(this)
            val params = LinearLayout.LayoutParams(500, 1000)
            params.marginEnd = 16
            imageView.setBackgroundColor(Color.GRAY)
            imageView.layoutParams = params
            hrLinearLayout.addView(imageView)
            applicationContext.toAnimate(R.anim.slide_from_right, imageView)
        }
    }
}