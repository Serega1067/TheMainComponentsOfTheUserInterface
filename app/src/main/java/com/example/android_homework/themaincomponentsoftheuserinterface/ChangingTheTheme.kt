package com.example.android_homework.themaincomponentsoftheuserinterface

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import com.example.android_homework.themaincomponentsoftheuserinterface.databinding.ActivityChangingTheThemeBinding

//import android.app.UiModeManager.MODE_NIGHT_YES
//import android.app.UiModeManager.MODE_NIGHT_NO

class ChangingTheTheme : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityChangingTheThemeBinding.inflate(layoutInflater)

        binding.buttonChangingTheme.setOnClickListener {
            if (AppCompatDelegate.getDefaultNightMode() == MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
            }
        }

        binding.buttonSave.setOnClickListener {
            save()
            finish()
        }

        setContentView(binding.root)
//        setContentView(R.layout.activity_changing_the_theme)
//        findViewById<Button>(R.id.buttonChangingTheme).setOnClickListener {
//            if (AppCompatDelegate.getDefaultNightMode() == MODE_NIGHT_YES) {
//                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
//            } else {
//                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
//            }
//        }
    }

    private fun save() {
        Toast.makeText(this, "Saving process", Toast.LENGTH_SHORT).show()
    }
}