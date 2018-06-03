package com.example.preston.kotlindice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    var history = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = findViewById<TextView>(R.id.history)
        text.setOnClickListener({v -> clickFunction(v)})
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when(item?.itemId) {
        R.id.action_stats -> {
            // switch to other activity
            goToStats()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
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

    val MESSAGE = "com.example.preston.kotlindice.STATS"
    fun goToStats() {
        val test: HashMap<Int, Int> = HashMap()
        val intent = Intent(this, Stats::class.java).apply { putExtra(MESSAGE, test) }
        startActivity(intent)
    }

    fun updateView() {
        // R.layout.activity_main set text
        val v = findViewById<TextView>(R.id.history)
        v.text = history
    }

    fun rollDice(): List<Int> =
        listOf(rollDi(), rollDi())

    fun rollDi(): Int {
        return (1..7).random()
    }
}
