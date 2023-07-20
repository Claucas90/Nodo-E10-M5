package com.claucas90.e10m5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var isPhoneFolded = false
    private var isScreenLightOn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val powerButton = findViewById<Button>(R.id.powerButton)
        powerButton.setOnClickListener {
            if (!isPhoneFolded) {
                isScreenLightOn = !isScreenLightOn
                updateScreenLightStatus()
            } else {
                showToast("The phone is folded. Open it to turn on the screen.")
            }
        }

        val foldButton = findViewById<Button>(R.id.foldButton)
        foldButton.setOnClickListener {
            isPhoneFolded = true
            isScreenLightOn = false
            updateScreenLightStatus()
        }

        val unfoldButton = findViewById<Button>(R.id.unfoldButton)
        unfoldButton.setOnClickListener {
            isPhoneFolded = false
            updateScreenLightStatus()
        }
    }

    private fun updateScreenLightStatus() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        showToast("The phone screen's light is $phoneScreenLight.")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
