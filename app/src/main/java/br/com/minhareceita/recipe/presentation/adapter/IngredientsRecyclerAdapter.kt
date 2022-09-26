package br.com.minhareceita.recipe.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.minhareceita.R
import br.com.minhareceita.meal.domain.model.Meal

class IngredientsRecyclerAdapter(
    private val meal: ArrayList<Meal>
) : Adapter<IngredientsRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryName: TextView = view.findViewById(R.id.ingredient)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recipe_activity, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        meal[position].apply {
            holder.categoryName.text = this.name
        }
    }

    override fun getItemCount(): Int = meal.size

}