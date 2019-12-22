package com.example.razer

import android.content.Context
import android.util.DisplayMetrics
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {
    val ANIM_DURATION = 300L
    val CONNECTING_TRANSLATION_YBY = 125.0F
    val TRANSLATION_YBY = 80.0F
    val TRANSLATION_XBY = 20.0F
    fun convertDpToPixel(dp: Float, context: Context): Float {
        return dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }
}