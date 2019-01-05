package com.example.preston.kotlindice

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.MenuInflater
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.roll_tracker.*

class RollTracker : AppCompatActivity() {

    val count: HashMap<Int, Int> = HashMap(12)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.roll_tracker)

        button7.setOnClickListener {v -> clickFunction(v, 7)}
        button2.setOnClickListener {v -> clickFunction(v, 2)}
        button3.setOnClickListener {v -> clickFunction(v, 3)}
        button4.setOnClickListener {v -> clickFunction(v, 4)}
        button5.setOnClickListener {v -> clickFunction(v, 5)}
        button6.setOnClickListener {v -> clickFunction(v, 6)}
        button8.setOnClickListener {v -> clickFunction(v, 8)}
        button9.setOnClickListener {v -> clickFunction(v, 9)}
        button10.setOnClickListener {v -> clickFunction(v, 10)}
        button11.setOnClickListener {v -> clickFunction(v, 11)}
        button12.setOnClickListener {v -> clickFunction(v, 12)}
    }

    fun clickFunction(v: View, r: Int)  {
        count.put(r, (count.get(r) ?: 0) + 1)
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
    fun goToStats() {
        val extras = Bundle().apply { putSerializable(MESSAGE, count) }
        val intent = Intent(this, Stats::class.java).apply { putExtras(extras) }
        startActivity(intent)
    }
}
