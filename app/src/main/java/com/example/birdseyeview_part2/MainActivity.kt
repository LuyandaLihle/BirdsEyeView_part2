package com.example.birdseyeview_part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import com.example.birdseyeview_part2.accounts.LoginActivity
import com.example.birdseyeview_part2.accounts.SignUpActivity
import com.example.birdseyeview_part2.databinding.ActivityMainBinding
import com.example.birdseyeview_part2.databinding.ActivityRegisterBinding
import com.example.birdseyeview_part2.databinding.ActivityLoginBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.registerBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        binding.loginBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

}