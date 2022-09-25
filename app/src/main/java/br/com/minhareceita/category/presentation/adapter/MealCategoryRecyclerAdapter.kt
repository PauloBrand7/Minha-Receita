package br.com.minhareceita.category.presentation.adapter

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
import br.com.minhareceita.meal.presentation.activity.MealsActivity
import com.bumptech.glide.Glide

class MealCategoryRecyclerAdapter(
    private val context: Context,
    private val categoriesList: ArrayList<MealCategory>
) : Adapter<MealCategoryRecyclerAdapter.ViewHolder>(), Filterable {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryName: TextView = view.findViewById(R.id.category_name)
        val categoryImage: ImageView = view.findViewById(R.id.category_image)
    }

    private var filteredCategoriesList = categoriesList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        filteredCategoriesList[position].apply {
            Glide.with(holder.itemView).load(this.image).into(holder.categoryImage)
            holder.categoryName.text = this.categoryName
            holder.itemView.setOnClickListener {
                val intent = Intent(context, MealsActivity::class.java)
                intent.putExtra("CATEGORYNAME", categoryName)
                startActivity(context, intent, Bundle())
            }
        }
    }

    override fun getItemCount(): Int = filteredCategoriesList.size

    override fun getFilter(): Filter {

        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val searchWord = constraint?.toString() ?: ""

                filteredCategoriesList = if (searchWord.isEmpty()) {
                    categoriesList
                } else {
                    val filteredList = ArrayList<MealCategory>()
                    categoriesList
                        .filter {
                            (it.categoryName.lowercase().contains(searchWord.lowercase()))
                        }
                        .forEach { filteredList.add(it) }

                    filteredList
                }

                return FilterResults().apply { values = filteredCategoriesList }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredCategoriesList = if (results?.values == null) {
                    categoriesList
                } else {
                    results.values as ArrayList<MealCategory>
                }
                notifyDataSetChanged()
            }
        }
    }
}