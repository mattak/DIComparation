package me.mattak.dicomaration.di

import androidx.activity.ComponentActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BaseActivity: ComponentActivity() {
    @Inject
    lateinit var analytics: AnalyticsAdapter
}