package br.com.minhareceita.meal.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.minhareceita.R
import br.com.minhareceita.category.presentation.MealCategoryRecyclerAdapter
import br.com.minhareceita.core.MainActivity
import br.com.minhareceita.core.navToNetworkErrorFragment
import br.com.minhareceita.databinding.FragmentMealBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealsFragment : Fragment() {

    private val viewModel: MealsViewModel by viewModels()
    private lateinit var binding: FragmentMealBinding
    private lateinit var adapter: MealsRecyclerAdapter
    private lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMealBinding.inflate(layoutInflater)
        mainActivity = activity as MainActivity
        setupExtras()
        setupRecyclerView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkInternetNetwork(view)
        fillsList()
        navToMealDetailFragment(view)
        mainActivity.getSearchBar().setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })
    }

    private fun setupExtras() {
        arguments?.getString(MealCategoryRecyclerAdapter.TAG)?.let {
            viewModel.category = it
        }
    }

    private fun setupRecyclerView() {
        adapter = MealsRecyclerAdapter()
        binding.apply {
            contentMeal.layoutManager =
                LinearLayoutManager(
                    requireActivity().applicationContext,
                    LinearLayoutManager.VERTICAL,
                    false
                )
            contentMeal.adapter = adapter
        }
    }

    private fun fillsList() {
        viewModel.meals.observe(viewLifecycleOwner) {
            adapter.updateList(it)
        }
    }

    private fun checkInternetNetwork(view: View) {
        viewModel.errorMessage.observe(viewLifecycleOwner) {
            view.navToNetworkErrorFragment()
        }
    }

    private fun navToMealDetailFragment(view: View) {
        adapter.setOnItemClickListener {
            view.findNavController().navigate(
                R.id.nav_meal_detail,
                bundleOf(MealsRecyclerAdapter.TAG to it)
            )
        }
    }
}