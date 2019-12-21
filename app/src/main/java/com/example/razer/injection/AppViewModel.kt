package com.example.razer.injection

import androidx.lifecycle.ViewModel

abstract class AppViewModel: ViewModel(), BaseViewModel {
    var isSearchEnabled: Boolean = true
    var isCancelEnabled: Boolean = false
}
