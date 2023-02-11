package me.mattak.dicomaration.di

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
//        val component = DaggerAppComponent.builder().build()
    }
}