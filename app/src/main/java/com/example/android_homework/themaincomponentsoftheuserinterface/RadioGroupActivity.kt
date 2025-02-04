package com.example.android_homework.themaincomponentsoftheuserinterface

import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

private const val NONE = -1

class RadioGroupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_group)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener { _, buttonId ->
            when (buttonId) {
                R.id.radioButton -> showSnackBar("Один")
                R.id.radioButton2 -> showSnackBar("Два")
                R.id.radioButton3 -> showSnackBar("Три")
                R.id.radioButton4 -> showSnackBar("Четыре")
                NONE -> showSnackBar("Ничего")
            }
        }
        findViewById<Button>(R.id.button).setOnClickListener {
            radioGroup.clearCheck()
        }
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(
            findViewById(
                android.R.id.content
            ),
            message,
            Snackbar.LENGTH_SHORT
        ).show()
    }
}