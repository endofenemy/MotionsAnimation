package com.ejaago.animations.utils

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils

fun Context.toAnimate(id:Int,view:View){
    val animation=AnimationUtils.loadAnimation(this,id)
    view.startAnimation(animation)
}