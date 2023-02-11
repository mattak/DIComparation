package me.mattak.dicomparation.domain

import javax.inject.Inject

interface AnalyticsService {
    fun analyticsMethods()
}

class AnalyticsServiceImpl @Inject constructor() : AnalyticsService {
    override fun analyticsMethods() {
        android.util.Log.d("__DEBUG__", "AnalyticsServiceImpl.analyticsMethods")
    }
}
