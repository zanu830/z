package com.example.foodiesrecipebook

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.foodiesrecipebook.databinding.ActivityVerifyPhoneBinding
import java.util.regex.Pattern

class VerifyPhone : AppCompatActivity() {
    private lateinit var binding: ActivityVerifyPhoneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyPhoneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp1.setOnClickListener {
            val phoneNumber = binding.etPhoneNumber.text.toString().trim()

            if (validatePhoneNumber(phoneNumber)) {
                val intent = Intent(this, PhoneCode::class.java)
                intent.putExtra("PHONE_NUMBER", phoneNumber)
                startActivity(intent)
            }
        }
    }

    private fun validatePhoneNumber(phoneNumber: String): Boolean {
        // Regular expression to match an 11-digit phone number
        val phoneNumberPattern = "^[0-9]{11}$"

        return when {
            phoneNumber.isEmpty() -> {
                binding.etPhoneNumber.error = "Phone number is required"
                false
            }
            !Pattern.matches(phoneNumberPattern, phoneNumber) -> {
                binding.etPhoneNumber.error = "Invalid phone number"
                false
            }
            else -> {
                binding.etPhoneNumber.error = null
                true
            }
        }
    }
}
