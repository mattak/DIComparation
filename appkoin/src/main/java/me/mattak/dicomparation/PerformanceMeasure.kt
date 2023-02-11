package me.mattak.dicomparation

object PerformanceMeasure {
    private val times = mutableMapOf<String, Long>()
    fun start(tag: String) {
        times[tag] = System.currentTimeMillis()
    }

    fun end(tag: String) {
        val start = times[tag] ?: return
        val end = System.currentTimeMillis()
        android.util.Log.d("__DEBUG__", "[$tag]\t${end - start}ms")
    }
}