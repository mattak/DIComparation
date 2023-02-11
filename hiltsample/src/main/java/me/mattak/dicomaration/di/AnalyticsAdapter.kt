package me.mattak.dicomaration.di

import javax.inject.Inject

class AnalyticsAdapter @Inject constructor(
    private val service: AnalyticsService
) {
    fun execute() {
        service.analyticsMethods()
    }
}