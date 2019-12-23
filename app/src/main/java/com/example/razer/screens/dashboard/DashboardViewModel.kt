package com.example.razer.screens.dashboard

import android.app.Application
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.razer.R
import com.example.razer.extensions.filterEmpty
import com.example.razer.injection.AppViewModel

class DashboardViewModel(val context: Application) : AppViewModel() {
    lateinit var bottomSheetListner: BottomSheetListener

    fun onBottomSheetClick(view: View) {
            bottomSheetListner?.onOptionSelected(view)
    }

    interface BottomSheetListener {
        fun onOptionSelected(view: View)
        fun onBottomBarTVClick()
    }

}
