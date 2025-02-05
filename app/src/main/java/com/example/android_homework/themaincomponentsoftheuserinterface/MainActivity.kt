package com.example.android_homework.themaincomponentsoftheuserinterface

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_homework.themaincomponentsoftheuserinterface.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val binding = ActivityMainBinding.inflate(layoutInflater)

        binding.buttonRadioGroupActivity.setOnClickListener {
            val intent = Intent(this, RadioGroupActivity::class.java)
            startActivity(intent)
        }
        binding.buttonEditTextActivity.setOnClickListener {
            val intent = Intent(this, EditTextActivity::class.java)
            startActivity(intent)
        }
        binding.buttonTextInputLayoutActivity.setOnClickListener {
            val intent = Intent(this, TextInputLayoutActivity::class.java)
            startActivity(intent)
        }
        binding.buttonChangingTheTheme.setOnClickListener {
            val intent = Intent(this, ChangingTheTheme::class.java)
            startActivity(intent)
        }

        setContentView(binding.root)
    }
}