package com.ejaago.animations.utils

import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.ProgressBar


class ProgressBarAnimation(
    var progressBar: ProgressBar,
    var from: Int = 0,
    var to: Int = 0
) : Animation() {

    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        super.applyTransformation(interpolatedTime, t)
        val value: Float = from + (to - from) * interpolatedTime
        progressBar.setProgress(value.toInt())
    }


}