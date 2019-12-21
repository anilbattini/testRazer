package com.example.razer.injection

import android.view.View

interface BaseViewModel {
    fun onSearchClick(view: View) {}
    fun onCancelClick(view: View) {}
}
