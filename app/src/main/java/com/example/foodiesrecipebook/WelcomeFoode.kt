package com.example.foodiesrecipebook

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.foodiesrecipebook.databinding.ActivityWelcomeFoodeBinding
import java.util.regex.Pattern

class WelcomeFoode : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeFoodeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeFoodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvSign.setOnClickListener {
            val intent=Intent(this,SignUp::class.java)
            startActivity(intent)
        }

        binding.btnVerify.setOnClickListener {
            val email = binding.etFooie.text.toString().trim()
            val password = binding.etFood.text.toString().trim()

            if (validateEmail(email) && validatePassword(password)) {
                // Proceed with your next steps (e.g., log in the user)
                Toast.makeText(this, "Validation Successful", Toast.LENGTH_SHORT).show()

                // Delay opening the next screen for 2 seco   nds
                Handler().postDelayed({
                    val intent = Intent(this, HomeFoodie::class.java)
                    startActivity(intent)
                }, 2000)
            }
        }
    }

    private fun validateEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return if (email.isEmpty()) {
            binding.etFooie.error = "Email is required"
            false
        } else if (!Pattern.matches(emailPattern, email)) {
            binding.etFooie.error = "Invalid email address"
            false
        } else {
            binding.etFooie.error = null
            true
        }
    }

    private fun validatePassword(password: String): Boolean {
        // Password must be at least 6 characters long
        return if (password.isEmpty()) {
            binding.etFood.error = "Password is required"
            false
        } else if (password.length < 6) {
            binding.etFood.error = "Password must be at least 6 characters long"
            false
        } else {
            binding.etFood.error = null
            true
        }
    }
}
