package com.ejaago.animations.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ejaago.animations.R
import com.ejaago.animations.utils.toAnimate
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_confirm.*
import kotlinx.android.synthetic.main.fragment_play.*
import kotlinx.android.synthetic.main.fragment_wallet.*


class PlayFragment() : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_play, container, false);
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.applicationContext?.toAnimate(R.anim.zoom_in, welcome)
        activity?.applicationContext?.toAnimate(R.anim.slide_from_right, l_one)
        activity?.applicationContext?.toAnimate(R.anim.slide_from_right, l_two)
        activity?.applicationContext?.toAnimate(R.anim.bottom_up, next_button)


        next_button.setOnClickListener {
            play_layout.visibility = View.GONE
            wallet_layout.visibility = View.VISIBLE

            activity?.applicationContext?.toAnimate(R.anim.zoom_in, wallet_title_one)
            activity?.applicationContext?.toAnimate(R.anim.zoom_in, wallet_title_two)
            activity?.applicationContext?.toAnimate(R.anim.slide_from_right, circle_one)
            activity?.applicationContext?.toAnimate(R.anim.slide_from_right, circle_two)
            activity?.applicationContext?.toAnimate(R.anim.slide_from_right, circle_three)
            activity?.applicationContext?.toAnimate(R.anim.slide_from_left, wallet)
            activity?.applicationContext?.toAnimate(R.anim.slide_from_left, wallet_text)
        }


        wallet_next.setOnClickListener {
            wallet_layout.visibility = View.GONE

            confirm_layout.visibility = View.VISIBLE

            activity?.applicationContext?.toAnimate(R.anim.zoom_in,ready_text)
            activity?.applicationContext?.toAnimate(R.anim.zoom_in,oswald_text)
            activity?.applicationContext?.toAnimate(R.anim.slide_from_right,round_one)
            activity?.applicationContext?.toAnimate(R.anim.slide_from_right,round_two)
            activity?.applicationContext?.toAnimate(R.anim.slide_from_right,round_three)
            activity?.applicationContext?.toAnimate(R.anim.slide_from_left,confirm_wallet)
            activity?.applicationContext?.toAnimate(R.anim.slide_from_left,confirm_wallet_text)


        }


    }
}
