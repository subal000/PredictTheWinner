package com.example.android.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.myapplication.data.PredictedRepository

@Suppress("UNCHECKED_CAST")
class PredictionViewModelFactory(
    private val repository: PredictedRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PredictionViewModel(repository) as T
    }
}