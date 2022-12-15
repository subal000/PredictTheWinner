package com.example.android.myapplication.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "predicted_item")
data class Predicteditem(
@ColumnInfo(name = "predicted_name")
var yourPredicted_item: String,
@ColumnInfo(name = "team_1")
var yourTeam1: String,
@ColumnInfo(name = "team_2")
var yourTeam2: String
) {
@PrimaryKey(autoGenerate = true)
var id : Int? = null
}