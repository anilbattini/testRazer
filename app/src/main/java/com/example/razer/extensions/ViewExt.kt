package com.example.razer.extensions

import android.os.SystemClock
import android.view.View

fun View.onClick(cb: (View) -> Unit){
    var lastClickTime = 0
    this.setOnClickListener {
        if (SystemClock.elapsedRealtime() - lastClickTime < 1000){
            return@setOnClickListener
        }

        lastClickTime = SystemClock.elapsedRealtime().toInt()
        cb.invoke(it)
    }
}