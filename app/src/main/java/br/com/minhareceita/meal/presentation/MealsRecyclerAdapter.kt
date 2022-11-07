package br.com.minhareceita.meal.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.minhareceita.R
import br.com.minhareceita.meal.domain.model.Meal
import br.com.minhareceita.mealDetails.presentation.MealDetailsActivity
import com.bumptech.glide.Glide

class MealsRecyclerAdapter(
    private val context: Context
) : Adapter<MealsRecyclerAdapter.ViewHolder>(), Filterable {

    companion object {
        const val TAG = "RECIPEID"
    }

    private var meals = listOf<Meal>()
    private var filteredMeals = listOf<Meal>()

    fun updateList(list: List<Meal>) {
        filteredMeals = list
        meals = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        filteredMeals[position].apply {
            Glide.with(holder.itemView).load(image).into(holder.categoryImage)
            holder.categoryName.text = name
            holder.itemView.setOnClickListener {
                val intent = Intent(context, MealDetailsActivity::class.java)
                intent.putExtra(TAG, id)
                startActivity(context, intent, Bundle())
            }
        }
    }

    override fun getItemCount(): Int = filteredMeals.size

    override fun getFilter(): Filter {

        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val searchWord = constraint?.toString() ?: ""

                if (searchWord.isEmpty()) {
                    return FilterResults().apply { values = meals }
                }

                return FilterResults().apply {
                    values = filteredMeals.filter {
                        (it.name.lowercase().contains(searchWord.lowercase()))
                    }
                }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredMeals = results?.values?.let { it as List<Meal>} ?: meals
                notifyDataSetChanged()
            }
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryName: TextView = view.findViewById(R.id.category_name)
        val categoryImage: ImageView = view.findViewById(R.id.category_image)
    }
}