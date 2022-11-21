package br.com.minhareceita.mealDetails.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.minhareceita.R
import br.com.minhareceita.meal.domain.model.Meal
import org.w3c.dom.Text

class MealDetailsRecyclerAdapter : Adapter<MealDetailsRecyclerAdapter.ViewHolder>() {

    private var meal = arrayListOf<String?>()

    fun updateList(list: List<String?>) {
        list.forEach {
            if (!it.isNullOrEmpty()) {
                meal.add(it)
            }
        }
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ingredient: TextView = view.findViewById(R.id.ingredient)
        val measure: TextView = view.findViewById(R.id.measure)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_ingredient, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        meal[position].takeIf { !it.isNullOrEmpty() }?.let {
            holder.ingredient.text = it.substring(0, it.indexOf("."))
            holder.measure.text = it.substring(it.indexOf(".")).replace(".", "")
        }
    }

    override fun getItemCount(): Int = meal.size
}