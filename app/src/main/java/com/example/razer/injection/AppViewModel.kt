package com.example.razer.injection

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

abstract class AppViewModel: ViewModel(), BaseViewModel {
    var isSearchEnabled: ObservableField<Int> = ObservableField(View.VISIBLE)
    var isCancelEnabled: ObservableField<Int> = ObservableField(View.GONE)

    fun updateSearchBtn() {
        isSearchEnabled.set(if (isSearchEnabled.get() == View.VISIBLE) View.GONE else View.VISIBLE)
    }

    fun updateCancelBtn() {
        isCancelEnabled.set(if (isCancelEnabled.get() == View.VISIBLE) View.GONE else View.VISIBLE)
    }
}
