package com.example.foodiesrecipebook

import adapter.CustomPagerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodiesrecipebook.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class Main : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the ViewPager with the custom adapter
        val pagerAdapter = CustomPagerAdapter(this)
        binding.viewpager.adapter = pagerAdapter

        val titles = listOf(
            "Share Recipe",
            "Salty Food",
            "Kitchen Salty"
        )

        // Set up the TabLayout with ViewPager
        TabLayoutMediator(binding.tablayout, binding.viewpager) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }
}