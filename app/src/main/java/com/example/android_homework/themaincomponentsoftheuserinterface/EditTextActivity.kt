package com.example.android_homework.themaincomponentsoftheuserinterface

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text)

        val emailEditText = findViewById<EditText>(R.id.editTextEmailAddress)
        val passwordExitText = findViewById<EditText>(R.id.editTextPassword)
        val logInButton = findViewById<Button>(R.id.buttonLogIn)

        logInButton.setOnClickListener {
            val email = emailEditText.text
            val password = passwordExitText.text
            if (
                email.isNotBlank()
                && password.isNotBlank()
            ) {
                Toast.makeText(this, "Успешно", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Ошибка", Toast.LENGTH_SHORT).show()
            }
        }
    }
}