package br.com.minhareceita.mealDetails.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.minhareceita.R
import br.com.minhareceita.core.details
import br.com.minhareceita.core.navToNetworkErrorFragment
import br.com.minhareceita.databinding.FragmentMealDetailBinding
import br.com.minhareceita.meal.domain.model.Meal
import br.com.minhareceita.meal.presentation.MealsRecyclerAdapter
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealDetailsFragment : Fragment() {

    private val viewModel: MealDetailsViewModel by viewModels()
    private lateinit var binding: FragmentMealDetailBinding
    private var adapter = MealDetailsRecyclerAdapter()
    private var youtubeUri = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMealDetailBinding.inflate(layoutInflater)
        initProperties()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkInternetNetwork(view)
        fillMealDetails()
    }

    private fun initProperties() {
        arguments?.getString(MealsRecyclerAdapter.TAG)?.let {
            viewModel.mealId = it
        }
        binding.apply {
            ingredientsList.layoutManager =
                LinearLayoutManager(
                    requireActivity().applicationContext,
                    LinearLayoutManager.VERTICAL, false
                )
            ingredientsList.adapter = adapter
            youtubeButton.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUri)))
            }
        }
    }

    private fun fillMealDetails() {
        viewModel.mealDetails.observe(viewLifecycleOwner) { meal ->
            bindingValues(meal)
            adapter.updateList(meal.details())
        }
    }

    private fun checkInternetNetwork(view: View) {
        viewModel.errorMessage.observe(viewLifecycleOwner) {
            view.navToNetworkErrorFragment()
        }
    }

    private fun bindingValues(meal: Meal) {
        binding.apply {
            Glide.with(this@MealDetailsFragment)
                .load(meal.image)
                .into(mealDetailImage)
            prepare.text = meal.instructions
            area.text = getString(R.string.txt_area) + meal.area
            mealTitle.text = meal.name
            meal.youtube?.let {
                youtubeButton.visibility = View.VISIBLE
                youtubeUri = it
            }
        }
    }
}