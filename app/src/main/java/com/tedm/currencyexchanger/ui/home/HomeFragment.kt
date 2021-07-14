package com.tedm.currencyexchanger.ui.home

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import com.tedm.currencyexchanger.R
import com.tedm.currencyexchanger.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_USER
    }
}