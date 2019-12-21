package com.example.razer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import com.example.razer.databinding.ActivityMainBinding
import com.example.razer.extensions.onClick
import com.example.razer.screens.connecting.ConnectingFragment
import kotlinx.android.synthetic.main.search.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val mainActivityViewModel: MainActivityViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        binding.rowViewModel = mainActivityViewModel
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.action_bar)
        search_button.onClick {
            supportFragmentManager.beginTransaction()
                .add(R.id.main_layout, ConnectingFragment())
                .commit()
        }

    }
}
