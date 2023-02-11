package me.mattak.dicomparation.domain

import javax.inject.Inject

class AnalyticsAdapter @Inject constructor(
    private val service: AnalyticsService
) {
    fun execute() {
        service.analyticsMethods()
    }
}