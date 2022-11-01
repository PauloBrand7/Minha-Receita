package br.com.minhareceita.mealDetails.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.minhareceita.R

class MealDetailsRecyclerAdapter: Adapter<MealDetailsRecyclerAdapter.ViewHolder>() {

    private var meal: ArrayList<String?> = arrayListOf()

    fun updateList(list: List<String?>) {
        list.forEach {
            if(!it.isNullOrEmpty()) {
                meal.add(it)
            }
        }
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryName: TextView = view.findViewById(R.id.ingredient)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_ingredient, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        meal[position].apply {
            holder.categoryName.text = this
        }
    }

    override fun getItemCount(): Int = meal.size
}