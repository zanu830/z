package com.example.foodiesrecipebook

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.foodiesrecipebook.databinding.ActivityRecipeDetailedBinding

class RecipeDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecipeDetailedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRecipeDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the recipe name from the intent
        val recipeName = intent.getStringExtra("RECIPE_NAME")

        // Set the recipe name to the TextView
        val recipeNameTextView = findViewById<TextView>(R.id.recipie_name)
        recipeNameTextView.text = recipeName

        // Set the recipe image based on the recipe name
        val recipeImageView = findViewById<ImageView>(R.id.img_frameavo)
        val imageResource = when (recipeName) {
            "potato_boats" -> R.drawable.whole_egg_potato_boats
            "avocado_egg" -> R.drawable.loaded_avocado_toast_scrambled_egg
            // Add more cases for other recipes
            else -> R.drawable.low_calorie // Use a default image if the recipe name is not recognized
        }
        recipeImageView.setImageResource(imageResource)

        // You can add more code here to set other details based on the recipe name
    }
}
