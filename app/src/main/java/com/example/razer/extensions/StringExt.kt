package com.example.razer.extensions

fun String?.filterEmpty(defaultValue: String = ""): String {
    return this ?: defaultValue
}