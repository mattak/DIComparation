package me.mattak.dicomparation

import android.app.Application

class MainApplication : Application() {
    override fun onCreate() {
        PerformanceMeasure.start("LAUNCH")
        super.onCreate()
    }
}