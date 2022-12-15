package com.example.android.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import com.example.android.myapplication.R
import com.example.android.myapplication.data.Predicteditem
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class StartPredicting : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory: PredictionViewModelFactory by instance()
    lateinit var viewModel: PredictionViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_predicting)
        viewModel = ViewModelProvider(this, factory).get(PredictionViewModel::class.java)
        val semiButton = findViewById(R.id.semiFinalButton) as Button
        semiButton.setOnClickListener(View.OnClickListener { val semiTeam1 = findViewById<TextView>(R.id.semi1).text.toString()
            val semiTeam2 = findViewById<TextView>(R.id.semi2).text.toString()
            val semiRadioGroup = findViewById<RadioGroup>(R.id.radioGroupSemi)
            val idSemi: Int = semiRadioGroup.checkedRadioButtonId
            if (idSemi!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = findViewById(idSemi)
                val yourSemiPred = radio.text.toString()
                val item = Predicteditem(yourSemiPred,semiTeam1,semiTeam2)
                viewModel.addPrediction(item)
            }else{
                // If no radio button checked in this radio group
                Toast.makeText(applicationContext,"Please select any one option:" +
                        " nothing has been selected",
                    Toast.LENGTH_SHORT).show()
            } })
        val finalButton = findViewById(R.id.finalButton) as Button
        finalButton.setOnClickListener(View.OnClickListener {
            val finalTeam1 = findViewById<TextView>(R.id.final1).text.toString()
            val finalTeam2 = findViewById<TextView>(R.id.final2).text.toString()
            val finalRadioGroup = findViewById<RadioGroup>(R.id.radioGroupFinal)
            val idFinal: Int = finalRadioGroup.checkedRadioButtonId
            if (idFinal!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = findViewById(idFinal)
                val yourFinalPred = radio.text.toString()
                val item = Predicteditem(yourFinalPred,finalTeam1,finalTeam2)
                viewModel.addPrediction(item)
            }else{
                // If no radio button checked in this radio group
                Toast.makeText(applicationContext,"Please select any one option:" +
                        " nothing has been selected",
                    Toast.LENGTH_SHORT).show()
            } })
}
}