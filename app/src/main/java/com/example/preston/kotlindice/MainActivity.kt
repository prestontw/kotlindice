package com.example.preston.kotlindice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    var history = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start

    /**
     * should maybe return a function that takes in a view
     * and updates the view with new history
     */
    fun clickFunction(v: View) {
        history = rollsToString(rollDice()) + "\n" + history
        updateView()
    }

    fun updateView() {
        // R.layout.activity_main set text
        val v = findViewById<TextView>(R.id.history)
        v.text = history
    }

    fun rollDice(): List<Int> {
        return listOf(rollDi(), rollDi())
    }

    fun rollDi(): Int {
        return (1..7).random()
    }
}
