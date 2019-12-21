package com.example.razer.injection

import com.example.razer.MainActivityViewModel
import com.example.razer.screens.connecting.ConnectingViewModel
import com.example.razer.screens.dashboard.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel { ConnectingViewModel(get()) }
    viewModel { DashboardViewModel(get()) }
    viewModel { MainActivityViewModel(get()) }
}