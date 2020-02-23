package com.example.giphy.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.giphy.R
import com.example.giphy.databinding.FragmentHomeBinding
import com.example.giphy.ui.base.BaseFragment
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private lateinit var homeAdapter: HomeAdapter
    private val viewModel: HomeViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            vm = viewModel
            lifecycleOwner = this@HomeFragment

            recycle.run {
                homeAdapter = HomeAdapter()
                adapter = homeAdapter
            }

        }

        lifecycleScope.launch {


        }


//        binding.btn.setOnClickListener {
//            (activity as MainActivity).replaceFragment(FavoriteFragment.newInstance())
//
//        }

    }


    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

}