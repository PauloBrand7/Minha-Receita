package br.com.minhareceita.category.presentation

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
import br.com.minhareceita.category.domain.model.MealCategory
import br.com.minhareceita.meal.presentation.MealsActivity
import com.bumptech.glide.Glide

class MealCategoryRecyclerAdapter(
    private val context: Context
) : Adapter<MealCategoryRecyclerAdapter.ViewHolder>(), Filterable {

    companion object {
        const val TAG = "CATEGORYNAME"
    }

    private var categories = listOf<MealCategory>()
    private var filteredCategories: List<MealCategory> = listOf()

    fun updateList(list: List<MealCategory>) {
        filteredCategories = list
        categories = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        filteredCategories[position].apply {
            Glide.with(holder.itemView).load(image).into(holder.categoryImage)
            holder.categoryName.text = categoryName
            holder.itemView.setOnClickListener {
                val intent = Intent(context, MealsActivity::class.java)
                intent.putExtra(TAG, categoryName)
                startActivity(context, intent, Bundle())
            }
        }
    }

    override fun getItemCount(): Int = filteredCategories.size

    override fun getFilter(): Filter {

        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val searchWord = constraint?.toString() ?: ""

                if (searchWord.isEmpty()) {
                    return FilterResults().apply { values = categories }
                }

                return FilterResults().apply {
                    values = filteredCategories.filter {
                        (it.categoryName.lowercase().contains(searchWord.lowercase()))
                    }
                }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredCategories = results?.values?.let { it as List<MealCategory> } ?: categories
                notifyDataSetChanged()
            }
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryName: TextView = view.findViewById(R.id.category_name)
        val categoryImage: ImageView = view.findViewById(R.id.category_image)
    }
}