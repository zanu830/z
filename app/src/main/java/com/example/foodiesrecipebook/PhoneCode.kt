package com.example.foodiesrecipebook

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.foodiesrecipebook.databinding.ActivityPhoneCodeBinding

class PhoneCode : AppCompatActivity() {
    private lateinit var binding: ActivityPhoneCodeBinding
    private lateinit var phoneNumber: String
    private lateinit var otp: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        phoneNumber = intent.getStringExtra("PHONE_NUMBER") ?: ""
        otp = phoneNumber.takeLast(4) // Last 4 digits of the phone number

        // Display the phone number above the OTP fields
        binding.tvFrameTxt.text = phoneNumber

        // Show the OTP in a toast
        Toast.makeText(this, otp, Toast.LENGTH_LONG).show()

        // Set up a text change listener to verify the OTP
        setupOtpInputListener()
    }

    private fun setupOtpInputListener() {
        val otpFields = listOf(binding.otpField1, binding.otpField2, binding.otpField3, binding.otpField4)

        for (field in otpFields) {
            field.addTextChangedListener {
                if (otpFields.all { it.text.length == 1 }) {
                    // All fields are filled
                    val enteredOtp = otpFields.joinToString("") { it.text.toString() }

                    if (enteredOtp == otp) {
                        // OTP is correct, navigate to HomeFoodie activity
                        val intent = Intent(this, HomeFoodie::class.java)
                        startActivity(intent)
                    } else {
                        // OTP is incorrect, show an error and reset fields
                        Toast.makeText(this, "Invalid OTP. Please try again.", Toast.LENGTH_LONG).show()
                        for (otpField in otpFields) {
                            otpField.text.clear()
                        }
                        Toast.makeText(this, otp, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}
