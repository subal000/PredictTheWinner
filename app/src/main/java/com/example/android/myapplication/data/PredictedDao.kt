package com.example.android.myapplication.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
@Dao
interface PredictedDao {
    @Insert
    suspend fun addPrediction(item: Predicteditem)
    @Delete
    suspend fun delete(item: Predicteditem)
    @Query("SELECT * FROM predicted_item")
    fun getAllPredictions() : LiveData<List<Predicteditem>>
}