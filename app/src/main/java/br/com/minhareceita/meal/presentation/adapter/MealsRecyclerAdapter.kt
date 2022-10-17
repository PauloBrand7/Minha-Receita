package br.com.minhareceita.meal.presentation.adapter

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
import br.com.minhareceita.mealDetails.presentation.activity.MealDetailsActivity
import com.bumptech.glide.Glide

class MealsRecyclerAdapter(
    private val context: Context
) : Adapter<MealsRecyclerAdapter.ViewHolder>(), Filterable {

    companion object {
        const val TAG = "RECIPEID"
    }

    private var mealsList: ArrayList<Meal> = arrayListOf()
    private var filteredMealsList: ArrayList<Meal> = arrayListOf()

    fun updateList(list: ArrayList<Meal>) {
        mealsList = list
        filteredMealsList = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryName: TextView = view.findViewById(R.id.category_name)
        val categoryImage: ImageView = view.findViewById(R.id.category_image)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        filteredMealsList[position].apply {
            Glide.with(holder.itemView).load(this.image).into(holder.categoryImage)
            holder.categoryName.text = this.name
            holder.itemView.setOnClickListener {
                val intent = Intent(context, MealDetailsActivity::class.java)
                intent.putExtra(TAG, id)
                startActivity(context, intent, Bundle())
            }
        }
    }

    override fun getItemCount(): Int = filteredMealsList.size

    override fun getFilter(): Filter {

        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val searchWord = constraint?.toString() ?: ""

                filteredMealsList = if (searchWord.isEmpty()) {
                    mealsList
                } else {
                    val filteredList = ArrayList<Meal>()
                    mealsList
                        .filter {
                            (it.name.lowercase().contains(searchWord.lowercase()))
                        }
                        .forEach { filteredList.add(it) }

                    filteredList
                }

                return FilterResults().apply { values = filteredMealsList }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredMealsList = if (results?.values == null) {
                    mealsList
                } else {
                    results.values as ArrayList<Meal>
                }
                notifyDataSetChanged()
            }
        }
    }
}