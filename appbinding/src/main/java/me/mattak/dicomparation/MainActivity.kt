package me.mattak.dicomparation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import me.mattak.dicomparation.databinding.ActivityMainBinding
import me.mattak.dicomparation.ui.TextCell
import me.mattak.dicomparation.ui.TextCellAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val adapter = TextCellAdapter()
        binding.recyclerView.adapter = adapter

        val list = mutableListOf<TextCell>()
        for (i in 0 until 100) {
            list.add(TextCell("Text $i"))
        }
        adapter.submitList(list)
        PerformanceMeasure.end("LAUNCH")
    }
}