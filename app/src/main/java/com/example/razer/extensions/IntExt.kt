package com.example.razer.extensions

import com.example.razer.R

fun Int?.filterColor(defaultValue: Int = R.color.grey_text_color): Int {
    return this ?: defaultValue
}