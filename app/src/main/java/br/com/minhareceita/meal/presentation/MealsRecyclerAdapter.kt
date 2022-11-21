package br.com.minhareceita.meal.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.minhareceita.R
import br.com.minhareceita.meal.domain.model.Meal
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class MealsRecyclerAdapter : Adapter<MealsRecyclerAdapter.ViewHolder>(), Filterable {

    companion object {
        const val TAG = "RECIPEID"
    }

    private var meals = listOf<Meal>()
    private var filteredMeals = listOf<Meal>()
    private var onItemClickListener: ((String) -> Unit)? = null

    fun setOnItemClickListener(listener: (String) -> Unit) {
        onItemClickListener = listener
    }

    fun updateList(list: List<Meal>) {
        filteredMeals = list
        meals = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_meal, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        filteredMeals[position].apply {
            Glide.with(holder.itemView).load(image).into(holder.mealImage)
            holder.mealName.text = name
            holder.itemView.setOnClickListener {
                onItemClickListener?.let {
                    it(id)
                }
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
                filteredMeals = results?.values?.let { it as List<Meal> } ?: meals
                notifyDataSetChanged()
            }
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mealName: TextView = view.findViewById(R.id.meal_name)
        val mealImage: ImageView = view.findViewById(R.id.meal_image)
    }
}