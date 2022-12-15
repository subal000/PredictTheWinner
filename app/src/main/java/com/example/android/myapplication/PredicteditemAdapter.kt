package com.example.android.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.myapplication.data.Predicteditem
import kotlinx.android.synthetic.main.predicted_items.view.*

class PredicteditemAdapter(
    var items: List<Predicteditem>,
    private val viewModel: PredictionViewModel
): RecyclerView.Adapter<PredicteditemAdapter.PredictedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PredictedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.predicted_items, parent, false)
        return PredictedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PredictedViewHolder, position: Int) {
        val curPrediction = items[position]
        holder.itemView.team1.text = curPrediction.yourTeam1
        holder.itemView.team2.text = curPrediction.yourTeam2
        holder.itemView.your_Prediction.text = curPrediction.yourPredicted_item
        holder.itemView.delete.setOnClickListener {
            viewModel.delete(curPrediction)
        }
    }

    inner class PredictedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}