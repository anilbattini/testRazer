package com.example.razer.screens.connecting

import android.app.Application
import android.view.View
import com.example.razer.injection.AppViewModel

class ConnectingViewModel(private val context: Application) : AppViewModel() {
    lateinit var navigationListener: NavigationListener

    override fun onSearchClick(view: View) {
        isSearchEnabled = false
        isCancelEnabled = true
        navigationListener?.goNext()
    }

    override fun onCancelClick(view: View) {
        isCancelEnabled = false
        isSearchEnabled = true
    }

    interface NavigationListener {
        fun goNext()
    }
}

