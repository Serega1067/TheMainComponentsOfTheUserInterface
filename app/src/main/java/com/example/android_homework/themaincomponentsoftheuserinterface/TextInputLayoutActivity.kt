package com.example.android_homework.themaincomponentsoftheuserinterface

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout

class TextInputLayoutActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_input_layout)

        val emailTextInputLayout = findViewById<TextInputLayout>(R.id.textInputLayout)
        val emailEditText = findViewById<EditText>(R.id.email)

        emailEditText.doOnTextChanged { text, _, _, _ ->
            if (isEmailValid(text)) {
                emailTextInputLayout.isErrorEnabled = false
            } else {
                emailTextInputLayout.error = "Некорректный Email"
                emailTextInputLayout.isErrorEnabled = true
            }
        }
    }
}

private fun isEmailValid(email: CharSequence?): Boolean {
    return !email.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}