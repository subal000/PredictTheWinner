package com.example.android.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance



class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val seeMyScore = findViewById<Button>(R.id.see_my_score_button)
        val startPredicting = findViewById<Button>(R.id.start_predicting_button)
        seeMyScore.setOnClickListener(View.OnClickListener {
            intent = Intent(applicationContext, SeeMyScore::class.java)
            Log.v("Hello","there")
            startActivity(intent)
        })
        startPredicting.setOnClickListener(View.OnClickListener {
            intent = Intent(applicationContext, StartPredicting::class.java)
            Log.v("Hoe","there")
            startActivity(intent)
        })

    }
}