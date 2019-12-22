package com.example.razer.screens.dashboard

import android.animation.Animator
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.razer.BaseFragment
import com.example.razer.R
import com.example.razer.databinding.DashboardFragmentBinding
import kotlinx.android.synthetic.main.ear_buds.*
import kotlinx.android.synthetic.main.ear_buds.left_earbud
import kotlinx.android.synthetic.main.ear_buds.right_earbud
import kotlinx.android.synthetic.main.ear_buds_connecting.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : BaseFragment() {
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
        triggerAnimation()
    }

    private fun triggerAnimation() {
        left_earbud.animate().translationYBy(convertDpToPixel(TRANSLATION_YBY, context!!))
            .duration = ANIM_DURATION
        val propertyAnimator =
            right_earbud.animate().translationYBy(convertDpToPixel(TRANSLATION_YBY, context!!))
        propertyAnimator.duration = ANIM_DURATION
        propertyAnimator.setListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}
            override fun onAnimationEnd(animation: Animator) {
                battery_indicator.visibility = View.VISIBLE
                left_earbud.alpha = 1f
                right_earbud.alpha = 1f
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
    }

}
