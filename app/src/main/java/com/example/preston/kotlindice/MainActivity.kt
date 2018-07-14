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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var history = ""
    val count: HashMap<Int, Int> = HashMap(12)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        historyView.setOnClickListener({v -> clickFunction(v)})
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
        val rolls = rollDice()
        val sum = rolls.sum()
        history = history + "\n" + rollsToString(rolls)
        count.put(sum, (count.get(sum) ?: 0) + 1)
        updateView()
    }

    fun goToStats() {
        val extras = Bundle().apply { putSerializable(MESSAGE, count) }
        val intent = Intent(this, Stats::class.java).apply { putExtras(extras) }
        startActivity(intent)
    }

    fun updateView() {
        // R.layout.activity_main set text
        // maybe save reference to this so don't need to keep on finding it
        // when updating view?
        historyView.text = history
        scroll.fullScroll(View.FOCUS_DOWN)
    }

    fun rollDice(): List<Int> =
        listOf(rollDi(), rollDi())

    fun rollDi(): Int {
        return (1..7).random()
    }
}
