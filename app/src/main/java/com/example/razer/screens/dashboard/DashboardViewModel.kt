package com.example.razer.screens.dashboard

import android.app.Application
import android.view.View
import com.example.razer.injection.AppViewModel

class DashboardViewModel(val context: Application) : AppViewModel() {
    override fun getSearchBtnVisibility(): Int {
        return View.VISIBLE
    }

    override fun getCancelBtnVisibility(): Int {
        return View.GONE
    }
}
