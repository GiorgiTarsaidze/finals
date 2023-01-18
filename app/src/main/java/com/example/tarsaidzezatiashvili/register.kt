package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.tarsaidzezatiashvili.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class register : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var signup: TextView
    private lateinit var goback2: Button

    private val firebaseAuth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()
        signupListeners()
    }

    private fun signupListeners() {
        password.setOnClickListener {
            password.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        }


        signup.setOnClickListener {
            val email = email.text.toString()
            val password = password.text.toString()

            if (email.isEmpty() || password.isEmpty()
                || password.length < 7 || password.contains(' ')){
                return@setOnClickListener
            }

            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Toast.makeText(this, "წარმატებულია", Toast.LENGTH_SHORT).show()
                    goToLogin()
                } else {
                    Toast.makeText(this, "სცადეთ თავიდან", Toast.LENGTH_SHORT).show()
                }
            }

        }
        goback2.setOnClickListener {
            goToLogin()
        }
    }

    private fun goToLogin(){
        startActivity(Intent(this, starter::class.java))
        finish()
    }

    private fun init(){
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        signup = findViewById(R.id.signup)
        goback2 = findViewById(R.id.goback2)
    }

}