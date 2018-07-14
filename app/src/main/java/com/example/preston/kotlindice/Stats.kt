package com.example.preston.kotlindice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_stats.*;

class Stats : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)
        val counts: HashMap<Int, Int> = intent.extras?.getSerializable(MESSAGE) as HashMap<Int, Int>
        val total = counts.values.sum()
        val ideal = idealNumRolls(total)
        report.text = mapsToReport(counts, ideal) + "\n\n(1..7).random() + (1..7).random()"
    }
}
