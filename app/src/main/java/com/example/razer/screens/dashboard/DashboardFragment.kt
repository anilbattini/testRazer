package com.example.razer.screens.dashboard

import android.animation.Animator
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.RenderProcessGoneDetail
import android.widget.TextView
import com.example.razer.BaseFragment
import com.example.razer.R
import com.example.razer.databinding.DashboardFragmentBinding
import com.example.razer.extensions.filterColor
import kotlinx.android.synthetic.main.ear_buds.*
import kotlinx.android.synthetic.main.ear_buds.left_earbud
import kotlinx.android.synthetic.main.ear_buds.right_earbud
import kotlinx.android.synthetic.main.ear_buds_connecting.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : BaseFragment(), DashboardViewModel.BottomSheetListener {
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
        dashboardViewModel.bottomSheetListner = this
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
                button_layout.visibility = View.VISIBLE
                left_earbud.alpha = 1f
                right_earbud.alpha = 1f
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
    }

    override fun onOptionSelected(view: View) {
        view?.let {

            val textView = it as TextView
            bottom_bar_selected_tv.text = textView.text
            updateItemTextColors(textView)
            bottom_sheet.visibility = View.GONE
            bottom_bar.visibility = View.VISIBLE
        }
    }

    private fun updateItemTextColors(textView: TextView) {
        val itemList = listOf(bottom_shee_tv1, bottom_shee_tv2, bottom_shee_tv3)
        itemList.forEach {
            it.setTextColor(
                if (it.id == textView.id)
                    context?.getColor(R.color.colorAccent).filterColor()
                else context?.getColor(R.color.grey_text_color).filterColor()
            )
        }
    }

    override fun onBottomBarTVClick() {
        bottom_bar.visibility = View.GONE
        bottom_sheet.visibility = View.VISIBLE
    }
}
