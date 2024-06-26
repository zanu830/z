package com.example.foodiesrecipebook

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodiesrecipebook.databinding.ActivityShareRecipeBinding

class share_recipe : AppCompatActivity() {
private lateinit var binding: ActivityShareRecipeBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityShareRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvRecipeShare.setOnClickListener {
        val intent=Intent(this, WelcomeFoode::class.java)
            startActivity(intent)

        }



        }
    }
