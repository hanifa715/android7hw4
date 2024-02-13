package com.example.android7hw4.statistics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android7hw4.R
import com.example.android7hw4.data.local.Statistics
import com.example.android7hw4.databinding.ItemStatisticsBinding

class StatisticsAdapter(val onClick: (statistic: Statistics) -> Boolean) :
    RecyclerView.Adapter<StatisticsAdapter.StatisticsViewHolder>() {

    private val list = arrayListOf<Statistics>()

    fun addStatistics(models: List<Statistics>) {
        list.clear()
        list.addAll(models)
        notifyDataSetChanged()
    }

    fun removeItem(position: Statistics) {
        list.remove(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatisticsViewHolder {
        return StatisticsViewHolder(
            ItemStatisticsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: StatisticsViewHolder, position: Int) =
        holder.bind(list[position])

    inner class StatisticsViewHolder(private val binding: ItemStatisticsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(statistic: Statistics) = with(binding) {
            tvStatusDetail.text = statistic.status?.replace("Результат: ", "")
            tvDifficultyDetail.text = statistic.difficulty?.replace("Сложность: ", "")
            tvMistakesDetail.text = statistic.mistakes
            imgIcon.setImageResource(
                if (statistic.status.equals("Результат: Победа")) R.drawable.ic_thumb_up
                else R.drawable.ic_thumb_down
            )
            itemView.setOnLongClickListener {
                onClick(statistic)
            }
        }

    }
}