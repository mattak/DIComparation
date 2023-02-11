package me.mattak.dicomparation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {
    override fun onCreate() {
        PerformanceMeasure.start("LAUNCH")
        super.onCreate()
    }
}