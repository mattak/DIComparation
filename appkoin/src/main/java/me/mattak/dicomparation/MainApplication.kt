package me.mattak.dicomparation

import androidx.multidex.MultiDexApplication
import me.mattak.dicomparation.di.repositoryModule
import me.mattak.dicomparation.di.useCaseModule
import me.mattak.dicomparation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : MultiDexApplication() {
    override fun onCreate() {
        PerformanceMeasure.start("LAUNCH")
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(repositoryModule, useCaseModule, viewModelModule)
        }
    }
}