package com.example.razer.screens.connecting

import android.app.Application
import android.view.View
import com.example.razer.injection.AppViewModel

class ConnectingViewModel(private val context: Application) : AppViewModel() {
    override fun getSearchBtnVisibility(): Int {
        return View.GONE
    }

    override fun getCancelBtnVisibility(): Int {
        return View.VISIBLE
    }
}