package me.mattak.dicomaration.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class AnalyticsModuleByBind {
    @Binds
    abstract fun bindAnalyticsService(impl: AnalyticsServiceImpl): AnalyticsService
}