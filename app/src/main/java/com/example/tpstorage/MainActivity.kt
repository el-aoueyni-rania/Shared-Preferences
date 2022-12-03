package com.example.tpstorage

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.blue

class MainActivity : AppCompatActivity() {
    lateinit var root:ConstraintLayout
    lateinit var counter:TextView
    lateinit var red:Button
    lateinit var green:Button
    lateinit var blue:Button
    lateinit var black:Button
    lateinit var white:Button
    lateinit var count:Button
    lateinit var save:Button
    lateinit var clear:Button
    lateinit var load:Button
    var color = Color.WHITE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreference:SharedPref=SharedPref(this)

        root = findViewById(R.id.root)
        counter = findViewById(R.id.counter)
        red = findViewById(R.id.red)
        green = findViewById(R.id.green)
        blue = findViewById(R.id.blue)
        black = findViewById(R.id.black)
        white = findViewById(R.id.white)
        count = findViewById(R.id.count)
        save = findViewById(R.id.save)
        clear = findViewById(R.id.clear)
        load = findViewById(R.id.load2)
        red.setOnClickListener {
            root.setBackgroundColor(Color.RED)
            color = Color.RED
        }
        green.setOnClickListener {
            root.setBackgroundColor(Color.GREEN)
            color = Color.GREEN
        }
        blue.setOnClickListener {
            root.setBackgroundColor(Color.BLUE)
            color = Color.BLUE
        }
        black.setOnClickListener {
            root.setBackgroundColor(Color.BLACK)
            color = Color.BLACK
        }
        white.setOnClickListener {
            root.setBackgroundColor(Color.WHITE)
            color = Color.WHITE
        }



        count.setOnClickListener {
            var count = counter.text.toString().toInt()
            count++
            counter.text = count.toString()
        }
        save.setOnClickListener {
            sharedPreference.save("counter",counter.text.toString())
            sharedPreference.save("color",color)
            Toast.makeText(this@MainActivity,"Data saved to shared preferences", Toast.LENGTH_SHORT).show()

        }
        clear.setOnClickListener {
            sharedPreference.clearSharedPreference()
            Toast.makeText(this@MainActivity,"Data Cleared from shared preferences", Toast.LENGTH_SHORT).show()
        }
        load.setOnClickListener {
            Toast.makeText(this@MainActivity,"Data Loaded from shared preferences", Toast.LENGTH_SHORT).show()
            counter.text = sharedPreference.getValueString("counter")!!
          //  root.setBackgroundColor(Color.BLUE)
            root.setBackgroundColor(sharedPreference.getValueInt("color")!!)
        }
    }

}