package com.example.razer.screens.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.razer.databinding.DashboardFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : Fragment() {
    private val dashboardViewModel: DashboardViewModel by viewModel()
    private lateinit var binding: DashboardFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DashboardFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.rowViewModel = dashboardViewModel
    }

}
