package com.example.razer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.razer.screens.connecting.ConnectingFragment
import kotlinx.android.synthetic.main.action_bar.*

class MainActivity : AppCompatActivity(), BaseFragment.IconListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.action_bar)
        supportFragmentManager.beginTransaction()
            .add(R.id.main_layout, ConnectingFragment())
            .commit()
    }

    override fun updateIcon() {
        settings_icon?.let {
            it.visibility = if (it.isVisible) View.GONE else View.VISIBLE
        }
    }
}
