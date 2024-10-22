package com.example.lab2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var firstButton: Button
    private lateinit var weightInput: EditText
    private lateinit var heightInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate has been called")
        setContentView(R.layout.activity_main)

        // Link UI elements
        firstButton = findViewById(R.id.first_button)
        weightInput = findViewById(R.id.plain_text_input)
        heightInput = findViewById(R.id.plain_text_input1)

        // Set click listener for the button
        firstButton.setOnClickListener {
            calculateBMI()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart has been called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume has been called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause has been called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop has been called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy has been called")
    }

    private fun calculateBMI() {
        val weightText = weightInput.text.toString()
        val heightText = heightInput.text.toString()

        if (weightText.isNotEmpty() && heightText.isNotEmpty()) {
            val weight = weightText.toFloat()
            val height = heightText.toFloat() / 100  // Convert cm to meters

            val bmi = weight / (height * height)

            // Display BMI result and category
            val bmiCategory = when {
                bmi < 18.5 -> "Underweight"
                bmi < 24.9 -> "Normal weight"
                bmi < 29.9 -> "Overweight"
                else -> "Obesity"
            }

            // Display BMI as a toast message
            Toast.makeText(this, "Your BMI is %.2f (%s)".format(bmi, bmiCategory), Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Please enter both weight and height", Toast.LENGTH_SHORT).show()
        }
    }
}
