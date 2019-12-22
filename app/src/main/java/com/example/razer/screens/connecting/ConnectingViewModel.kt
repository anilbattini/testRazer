package com.example.razer.screens.connecting

import android.app.Application
import android.view.View
import com.example.razer.injection.AppViewModel

class ConnectingViewModel(private val context: Application) : AppViewModel() {
    lateinit var navigationListener: NavigationListener

    override fun onSearchClick(view: View) {
        updateSearchBtn()
        navigationListener?.triggerSearch()
    }

    override fun onCancelClick(view: View) {
//        updateCancelBtn()
//        navigationListener.cancelSearch()
    }

    fun updateButtons() {
        updateSearchBtn()
        updateCancelBtn()
    }

    interface NavigationListener {
        fun triggerSearch()
        fun cancelSearch()
    }

}

