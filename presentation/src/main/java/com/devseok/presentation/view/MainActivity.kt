package com.devseok.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.devseok.presentation.R
import com.devseok.presentation.base.BaseActivity
import com.devseok.presentation.databinding.ActivityMainBinding
import com.devseok.presentation.viewmodel.MainViewModel
import com.pss.barlibrary.CustomBar.Companion.setTransparentBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun init() {
        setTransparentBar(this)
    }
}