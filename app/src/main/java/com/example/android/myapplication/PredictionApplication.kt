package com.example.android.myapplication

import android.app.Application
import com.example.android.myapplication.data.PredictedDatabase
import com.example.android.myapplication.data.repository.PredictedRepository
import com.example.android.myapplication.ui.PredictionViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class PredictionApplication: Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@PredictionApplication))
        bind() from singleton { PredictedDatabase(instance()) }
        bind() from singleton {
            PredictedRepository(
                instance()
            )
        }
        bind() from provider {
            PredictionViewModelFactory(
                instance()
            )
        }
    }
}