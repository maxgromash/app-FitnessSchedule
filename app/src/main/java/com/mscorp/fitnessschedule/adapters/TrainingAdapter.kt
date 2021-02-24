package com.mscorp.fitnessschedule.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mscorp.fitnessschedule.DayOfWeek
import com.mscorp.fitnessschedule.R
import com.mscorp.fitnessschedule.Training
import kotlinx.android.synthetic.main.lesson_item.view.*

class TrainingAdapter : RecyclerView.Adapter<TrainingAdapter.TrainingAdapterViewHolder>() {

    var trainingList = listOf<Training>()
        set(arr) {
            field = arr
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lesson_item, parent, false)
        return TrainingAdapterViewHolder(view)
    }

    override fun getItemCount(): Int = trainingList.size

    override fun onBindViewHolder(holder: TrainingAdapterViewHolder, position: Int) {
        val training = trainingList[position]
        holder.dayOfWeek.text = when (training.weekDay) {
            1 -> DayOfWeek.Monday
            2 -> DayOfWeek.Tuesday
            3 -> DayOfWeek.Wednesday
            4 -> DayOfWeek.Thursday
            5 -> DayOfWeek.Friday
            6 -> DayOfWeek.Saturday
            7 -> DayOfWeek.Sunday
            else -> DayOfWeek.Saturday
        }.name
        holder.place.text = training.place
        holder.timeEnd.text = training.endTime
        holder.title.text = training.name
        holder.timeStart.text = training.startTime
        holder.trainer.text = training.teacher
    }

    inner class TrainingAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.textViewName
        var timeStart: TextView = itemView.textViewTimeStart
        var timeEnd: TextView = itemView.textViewTimeEnd
        var trainer: TextView = itemView.textViewTrainer
        var dayOfWeek: TextView = itemView.textViewDayOfWeek
        var place: TextView = itemView.textViewPlace
    }
}