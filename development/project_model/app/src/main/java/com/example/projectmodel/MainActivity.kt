package com.example.projectmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val incremental = findViewById<TextView>(R.id.incremental)
        val increaseButton = findViewById<Button>(R.id.increaseButton)

        var number = 0

        increaseButton.setOnClickListener {
            number++
            incremental.text = number.toString()
        }

    }
}