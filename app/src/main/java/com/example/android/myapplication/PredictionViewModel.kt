package com.example.android.myapplication

import androidx.lifecycle.ViewModel
import com.example.android.myapplication.data.PredictedRepository
import com.example.android.myapplication.data.Predicteditem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PredictionViewModel (
    private val repository: PredictedRepository
) : ViewModel() {

    fun addPrediction(item: Predicteditem) =
        GlobalScope.launch {
            repository.addPrediction(item)
        }

    fun delete(item: Predicteditem) = GlobalScope.launch {
        repository.delete(item)
    }
    fun getAllPredictions() = repository.getAllPredictions()

}
