package com.example.razer.screens.connecting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.razer.R
import com.example.razer.databinding.ConnectingFragmentBinding
import com.example.razer.extensions.onClick
import com.example.razer.screens.dashboard.DashboardFragment
import kotlinx.android.synthetic.main.search.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ConnectingFragment : Fragment() {

    private lateinit var binding: ConnectingFragmentBinding
    private val connectingViewModel: ConnectingViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ConnectingFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.rowViewModel = connectingViewModel
        search_button.visibility = View.VISIBLE
        search_button.onClick {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.main_layout, DashboardFragment())
                ?.addToBackStack(this.javaClass.name)
                ?.commit()
        }
    }

}


