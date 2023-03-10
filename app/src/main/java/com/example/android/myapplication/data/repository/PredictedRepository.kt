package com.example.android.myapplication.data.repository

import com.example.android.myapplication.data.PredictedDatabase
import com.example.android.myapplication.data.Predicteditem

class PredictedRepository(
    private val db: PredictedDatabase
) {
    suspend fun addPrediction(item: Predicteditem) = db.getPredictedDao().addPrediction(item)
    suspend fun delete(item: Predicteditem) = db.getPredictedDao().delete(item)
    fun getAllPredictions() = db.getPredictedDao().getAllPredictions()
}