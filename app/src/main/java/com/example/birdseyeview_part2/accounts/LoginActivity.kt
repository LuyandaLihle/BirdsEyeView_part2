package com.example.birdseyeview_part2.accounts

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.birdseyeview_part2.LoadScreenPage
import com.example.birdseyeview_part2.MainActivity
import com.example.birdseyeview_part2.R
import kotlin.concurrent.thread
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var signupButton: Button
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.btnLogin)
        signupButton = findViewById(R.id.btnSignUp)
        firebaseAuth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(username, password)
                    .addOnCompleteListener { task ->
                        thread {
                            Looper.prepare()
                            if (task.isSuccessful) {
                                val intent = Intent(this, LoadScreenPage::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(
                                    this,
                                    "Details entered are incorrect!",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                            Looper.loop()
                        }
                    }
            } else {
                Toast.makeText(this, "Username and password are required!", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        signupButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}