package com.example.android.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.myapplication.others.PredicteditemAdapter
import com.example.android.myapplication.R
import kotlinx.android.synthetic.main.seemyscore.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


class SeeMyScore : AppCompatActivity(), KodeinAware {
    override val kodein by kodein()
    private val factory: PredictionViewModelFactory by instance()
    lateinit var viewModel: PredictionViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.seemyscore)
        viewModel = ViewModelProvider(this, factory).get(PredictionViewModel::class.java)
        val adapter = PredicteditemAdapter(listOf(), viewModel)
        rvPredicteditems.layoutManager = LinearLayoutManager(this)
        rvPredicteditems.adapter = adapter
        viewModel.getAllPredictions().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })
    }
}