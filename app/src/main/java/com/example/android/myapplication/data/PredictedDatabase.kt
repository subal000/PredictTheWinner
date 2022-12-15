package com.example.android.myapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Predicteditem::class],
    version = 1
)
abstract class PredictedDatabase : RoomDatabase() {
    abstract fun getPredictedDao(): PredictedDao

    companion object {
        @Volatile
        private var instance: PredictedDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
                instance
                    ?: createDatabase(
                        context
                    ).also { instance = it }
            }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                PredictedDatabase::class.java, "PredictedDB.db").build()
    }
}