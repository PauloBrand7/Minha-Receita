package br.com.minhareceita.category.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.minhareceita.R
import br.com.minhareceita.category.domain.model.MealCategory
import com.bumptech.glide.Glide

class MealCategoryRecyclerAdapter(
    private val categoriesList: List<MealCategory>
) : Adapter<MealCategoryRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categoriesList[position])
    }

    override fun getItemCount(): Int = categoriesList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val categoryName: TextView = view.findViewById(R.id.category_name)
        private val categoryImage: ImageView = view.findViewById(R.id.category_image)

        fun bind(category: MealCategory) {
            Glide.with(itemView).load(category.image).into(categoryImage)
            categoryName.text = category.categoryName
        }
    }
}