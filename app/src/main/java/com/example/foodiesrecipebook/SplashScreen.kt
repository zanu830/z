package com.example.foodiesrecipebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.foodiesrecipebook.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.delay

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash_screen)
  Handler().postDelayed(
      {
          val intent = Intent(this@SplashScreen, Main ::class.java)
          startActivity(intent)
          finish()

      }, 3000
        )

    }
}