package com.example.razer.screens.connecting

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.razer.BaseFragment
import com.example.razer.R
import com.example.razer.databinding.ConnectingFragmentBinding
import com.example.razer.screens.dashboard.DashboardFragment
import kotlinx.android.synthetic.main.action_bar.*
import kotlinx.android.synthetic.main.ear_buds.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class ConnectingFragment : BaseFragment(), ConnectingViewModel.NavigationListener {
    private lateinit var binding: ConnectingFragmentBinding
    private val connectingViewModel: ConnectingViewModel by viewModel()
    val animationHandler = Handler()

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
        connectingViewModel.navigationListener = this
    }

    override fun triggerSearch() {
        triggerSearchAnimation()
    }

    override fun cancelSearch() {
        cancelSearchAnimation()
    }

    private fun triggerSearchAnimation() {
        left_earbud.alpha = 0.6f
        right_earbud.alpha = 0.6f
        left_earbud.animate().translationYBy(-1 * convertDpToPixel(CONNECTING_TRANSLATION_YBY, context!!))
            .duration = ANIM_DURATION
        left_earbud.animate().translationXBy(-1 * convertDpToPixel(TRANSLATION_XBY, context!!))
            .duration = ANIM_DURATION
        right_earbud.animate().translationYBy(-1 * convertDpToPixel(CONNECTING_TRANSLATION_YBY, context!!))
            .duration = ANIM_DURATION
        val propertyAnimator =
            right_earbud.animate().translationXBy(convertDpToPixel(TRANSLATION_XBY, context!!))
        propertyAnimator.duration = ANIM_DURATION
        propertyAnimator.setListener(object : AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}
            override fun onAnimationEnd(animation: Animator) {
                connectingViewModel.updateCancelBtn()
                progress_bar.visibility = View.VISIBLE
                animationHandler.postDelayed({
                    mActivity?.updateIcon()
                    progress_bar_tv.text = getString(R.string.searching)
                    animationHandler.postDelayed({
                        mActivity?.updateIcon()
                        connectingViewModel.updateButtons()
                        goNext()
                    }, 2000)
                }, 2 * ANIM_DURATION)
            }
            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
    }

    private fun goNext() {
        fragmentManager?.beginTransaction()
            ?.replace(R.id.main_layout, DashboardFragment())
            ?.addToBackStack(this.javaClass.name)
            ?.commit()
    }

    private fun cancelSearchAnimation() {
        left_earbud.animate().translationYBy(CONNECTING_TRANSLATION_YBY).duration = ANIM_DURATION
        left_earbud.animate().translationXBy(TRANSLATION_XBY).duration = ANIM_DURATION
        right_earbud.animate().translationYBy(CONNECTING_TRANSLATION_YBY).duration = ANIM_DURATION
        val propertyAnimator = right_earbud.animate().translationXBy(-1 * TRANSLATION_XBY)
        propertyAnimator.duration = ANIM_DURATION
        propertyAnimator.setListener(object : AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                progress_bar.visibility = View.GONE
            }

            override fun onAnimationEnd(animation: Animator) {
                connectingViewModel.updateSearchBtn()
                animationHandler.removeCallbacksAndMessages(null)
                left_earbud?.alpha = 0.4f
                right_earbud?.alpha = 0.4f
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
    }
}


