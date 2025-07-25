package com.example.bmical

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightInput = findViewById<EditText>(R.id.heightInput)
        val weightInput = findViewById<EditText>(R.id.weightInput)
        val calculateBtn = findViewById<Button>(R.id.calculateBtn)
        val resultText = findViewById<TextView>(R.id.resultText)

        calculateBtn.setOnClickListener {
            val heightStr = heightInput.text.toString()
            val weightStr = weightInput.text.toString()

            if (heightStr.isNotEmpty() && weightStr.isNotEmpty()) {
                val height = heightStr.toFloat() / 100
                val weight = weightStr.toFloat()
                val bmi = weight / (height * height)
                resultText.text = "Your BMI: %.2f".format(bmi)
            } else {
                Toast.makeText(this, "Please enter both height and weight.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}