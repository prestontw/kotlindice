package com.example.preston.kotlindice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        history = rollsToString(rollDice())
    }

    fun rollDice(): List<Int> {
        return listOf(rollDi(), rollDi())
    }

    fun rollDi(): Int {
        return (1..7).random()
    }
}
