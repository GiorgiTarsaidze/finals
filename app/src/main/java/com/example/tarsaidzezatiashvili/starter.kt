package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.tarsaidzezatiashvili.R
import com.example.tarsaidzezatiashvili.space
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class starter : AppCompatActivity() {
    private lateinit var loginEmailEditText: EditText
    private lateinit var loginPasswordEditText: EditText
    private lateinit var loginButton: TextView
    private lateinit var loginGoToSignUpTextView: TextView
    private val firebaseAuth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starter)
        init()
        loginListeners()
    }

    private fun loginListeners() {

        loginPasswordEditText.setOnClickListener {
            loginPasswordEditText.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        }

        loginButton.setOnClickListener {
            val email = loginEmailEditText.text.toString()
            val password = loginPasswordEditText.text.toString()

            if (email.isEmpty()||password.isEmpty()){
                Toast.makeText(this, "მეილის ან პაროლის გრაფა ცარიელია", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task->
                if (task.isSuccessful){
                    startActivity(Intent(this,space::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "სცადეთ თავიდან", Toast.LENGTH_SHORT).show()
                }
            }

        }

        loginGoToSignUpTextView.setOnClickListener {
            startActivity(Intent(this,register::class.java))
            finish()
        }

    }

    private fun init(){
        loginEmailEditText = findViewById(R.id.Emailbar)
        loginPasswordEditText = findViewById(R.id.passwordbar)
        loginButton = findViewById(R.id.autorizacia)
        loginGoToSignUpTextView = findViewById(R.id.registrationbut)
    }
}