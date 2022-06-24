package com.devseok.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.devseok.presentation.R
import com.devseok.presentation.base.BaseActivity
import com.devseok.presentation.databinding.ActivitySplashBinding
import com.devseok.presentation.viewmodel.SplashViewModel
import com.devseok.presentation.widget.extension.startActivityAndFinish
import com.pss.barlibrary.CustomBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    private val splashViewmodel by viewModels<SplashViewModel>()
    private val appVersion = "1.0.0"

    override fun init() {
        CustomBar.setTransparentBar(this)
        splashViewmodel.checkAppVersion()
            .addOnSuccessListener {
                if (appVersion == it.value) {
                    this.startActivityAndFinish(this, MainActivity::class.java)
                } else {
                    longShowToast("앱 버전이 다릅니다.")
                }

            }
            .addOnFailureListener {
                shortShowToast("오류가 발생했습니다. 오류코드 - ${it.message}")
            }
    }
}