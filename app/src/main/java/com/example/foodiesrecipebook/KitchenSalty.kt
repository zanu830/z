package com.example.foodiesrecipebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodiesrecipebook.databinding.ActivityGlobalKitchenBinding
import com.example.foodiesrecipebook.databinding.ActivityKitchenSaltyBinding

class KitchenSalty : AppCompatActivity() {
    private lateinit var binding: ActivityKitchenSaltyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityKitchenSaltyBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_kitchen_salty)

        binding.tvSaltify.setOnClickListener {
            val intent= Intent(this,SignUp::class.java)
            startActivity(intent)
        }
    }
}