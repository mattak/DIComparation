package me.mattak.dicomparation.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.mattak.dicomparation.MainActivity
import me.mattak.dicomparation.di.activity.MainActivityModule

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}