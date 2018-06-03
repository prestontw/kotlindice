package com.example.preston.kotlindice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Stats : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)
        val counts: HashMap<Int, Int> = intent.extras?.getSerializable(MESSAGE) as HashMap<Int, Int>
        val total = counts.values.sum()
        val ideal = idealNumRolls(total)
        findViewById<TextView>(R.id.report).text = mapsToReport(counts, ideal)
    }
}
