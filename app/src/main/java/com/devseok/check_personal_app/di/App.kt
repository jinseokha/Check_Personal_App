package com.devseok.check_personal_app.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * @author Ha Jin Seok
 * @email seok270@gmail.com
 * @created 2022-06-16
 * @desc
 */
@HiltAndroidApp
class App : Application() {
    companion object {
        private lateinit var application : App

        fun getInstance() : App = application
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}