package br.com.minhareceita.category.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.minhareceita.R
import br.com.minhareceita.core.MainActivity
import br.com.minhareceita.core.navToNetworkErrorFragment
import br.com.minhareceita.databinding.FragmentCategoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealCategoryFragment : Fragment() {

    private val viewModel: MealCategoryViewModel by viewModels()
    private lateinit var binding: FragmentCategoryBinding
    private lateinit var adapter: MealCategoryRecyclerAdapter
    private lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(layoutInflater)
        mainActivity = activity as MainActivity
        setupRecyclerView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkInternetNetwork(view)
        fillsList()
        navToMealFragment(view)
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

    private fun setupRecyclerView() {
        adapter = MealCategoryRecyclerAdapter()
        binding.apply {
            contentCategory.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            contentCategory.adapter = adapter
        }
    }

    private fun fillsList() {
        viewModel.listOfCategories.observe(viewLifecycleOwner) { list ->
            adapter.updateList(list)
        }
    }

    private fun checkInternetNetwork(view: View) {
        viewModel.errorMessage.observe(viewLifecycleOwner) {
            view.navToNetworkErrorFragment()
        }
    }

    private fun navToMealFragment(view: View) {
        adapter.setOnItemClickListener {
            view.findNavController().navigate(
                R.id.nav_meal_fragment,
                bundleOf(MealCategoryRecyclerAdapter.TAG to it)
            )
        }
    }
}