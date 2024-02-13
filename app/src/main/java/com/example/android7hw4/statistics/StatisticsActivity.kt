package com.example.android7hw4.statistics

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.android7hw4.R
import com.example.android7hw4.data.local.Statistics
import com.example.android7hw4.databinding.ActivityStatisticsBinding

class StatisticsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStatisticsBinding

    private val viewModel: StatisticsViewModel by viewModels()
    private val adapter = StatisticsAdapter(this::onClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatisticsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter = adapter

        viewModel.getStatistic().observe(this) { statistic ->
            adapter.addStatistics(statistic)
        }
    }

    private fun onClick(position: Statistics): Boolean {
        val alertDialBuilder = AlertDialog.Builder(this)
            .setMessage("Вы хотите удалить статистику?")

            .setPositiveButton("Да") { _, _ ->
                viewModel.deleteStatistic(position).observe(this) {
                    adapter.removeItem(position)
                }
            }

            .setNegativeButton("Нет") { _, _ ->
                dismissKeyboardShortcutsHelper()
            }

        val alertDialog = alertDialBuilder.create()
        alertDialog.show()
        return true
    }
}