package com.example.foodiesrecipebook

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.foodiesrecipebook.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private val activityMap = mapOf(
        "PotatoBoats" to PotatoBoats::class.java,
        "AvocadoEgg" to AvocadoEgg::class.java,
        "CroissantSandwich" to CroissantSandwich::class.java,
        "EggsBenedict" to EggBendict::class.java,
        "MasalaOmelette" to MasalaOmelette::class.java,
        "Bazlama" to Bazlama::class.java
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Mapping of image views to recipe names
        val recipeMap = mapOf(
            binding.imgPote1 to "PotatoBoats",
            binding.imgToat to "AvocadoEgg",
            binding.imgSet1 to "CroissantSandwich",
            binding.imgSet2 to "EggsBenedict",
            binding.imageViewRecipe to "MasalaOmelette",
            binding.imageViewRecipe1 to "CroissantSandwich",
            binding.imageViewRecipe2 to "PotatoBoats",
            binding.imageViewRecipe3 to "EggsBenedict",
            binding.imageViewRecipe4 to "Bazlama",
            binding.imageViewRecipe5 to "AvocadoEgg"
        )

        // Set click listeners for each image view
        recipeMap.forEach { (imageView, RecipeName) ->
            imageView.setOnClickListener {
                openRecipeActivity(RecipeName)
            }
        }

        return binding.root
    }

    private fun openRecipeActivity(recipeName: String) {
        activityMap[recipeName]?.let { activityClass ->
            val intent = Intent(context, activityClass)
            intent.putExtra("RECIPE_NAME", recipeName)
            startActivity(intent)
        } ?: run {
            Toast.makeText(context, "Recipe not found", Toast.LENGTH_SHORT).show()
        }
    }
}
