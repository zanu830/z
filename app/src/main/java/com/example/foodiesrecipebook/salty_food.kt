package com.example.foodiesrecipebook

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodiesrecipebook.databinding.ActivitySaltyFoodBinding

class salty_food : AppCompatActivity() {
private lateinit var binding: ActivitySaltyFoodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
binding= ActivitySaltyFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvChef.setOnClickListener {
            intent=Intent(this,WelcomeFoode::class.java)
            startActivity(intent)
        }


    }
}