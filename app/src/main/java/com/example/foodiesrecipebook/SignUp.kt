package com.example.foodiesrecipebook

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.foodiesrecipebook.databinding.ActivitySignUpBinding
import java.util.regex.Pattern

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            val email = binding.etEmail1.text.toString().trim()
            val password = binding.etPass1.text.toString().trim()
            val verifyPassword = binding.etVerifyPass.text.toString().trim()

            if (validateEmail(email) && validatePassword(password, verifyPassword)) {
                // Proceed with your next steps (e.g., navigate to VerifyPhone activity)
                val intent = Intent(this, VerifyPhone::class.java)
                startActivity(intent)
            }
        }
    }

    private fun validateEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return if (email.isEmpty()) {
            binding.etEmail1.error = "Email is required"
            false
        } else if (!Pattern.matches(emailPattern, email)) {
            binding.etEmail1.error = "Invalid email address"
            false
        } else {
            binding.etEmail1.error = null
            true
        }
    }

    private fun validatePassword(password: String, verifyPassword: String): Boolean {
        return when {
            password.isEmpty() -> {
                binding.etPass1.error = "Password is required"
                false
            }
            password.length < 6 -> {
                binding.etPass1.error = "Password must be at least 6 characters long"
                false
            }
            password != verifyPassword -> {
                binding.etVerifyPass.error = "Passwords do not match"
                false
            }
            else -> {
                binding.etPass1.error = null
                binding.etVerifyPass.error = null
                true
            }
        }
    }
}
