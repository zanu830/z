package adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodiesrecipebook.KitchenSalty
import com.example.foodiesrecipebook.databinding.ActivityKitchenSaltyBinding
import com.example.foodiesrecipebook.databinding.ActivitySaltyFoodBinding
import com.example.foodiesrecipebook.databinding.ActivityShareRecipeBinding
import com.example.foodiesrecipebook.salty_food
import com.example.foodiesrecipebook.share_recipe

class CustomPagerAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val PAGE_COUNT = 3
        private const val PAGE_SHARE_RECIPE = 0
        private const val PAGE_SALTY_FOOD = 1
        private const val PAGE_KITCHEN_SALTY = 2
    }

    override fun getItemCount(): Int {
        return PAGE_COUNT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            PAGE_SHARE_RECIPE -> ShareRecipeViewHolder(
                ActivityShareRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            PAGE_SALTY_FOOD -> SaltyFoodViewHolder(
                ActivitySaltyFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            PAGE_KITCHEN_SALTY -> KitchenSaltyViewHolder(
                ActivityKitchenSaltyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ShareRecipeViewHolder -> holder.bind(context)
            is SaltyFoodViewHolder -> holder.bind(context)
            is KitchenSaltyViewHolder -> holder.bind(context)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ShareRecipeViewHolder(private val binding: ActivityShareRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(context: Context) {
            binding.tvRecipeShare.setOnClickListener {
                val intent = Intent(context, share_recipe::class.java)
                context.startActivity(intent)
            }
        }
    }

    inner class SaltyFoodViewHolder(private val binding: ActivitySaltyFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(context: Context) {
            binding.tvChef.setOnClickListener {
                val intent = Intent(context, salty_food::class.java)
                context.startActivity(intent)
            }
        }
    }

    inner class KitchenSaltyViewHolder(private val binding: ActivityKitchenSaltyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(context: Context) {
            binding.tvSaltify.setOnClickListener {
                val intent = Intent(context, KitchenSalty::class.java)
                context.startActivity(intent)
            }
        }
    }
}