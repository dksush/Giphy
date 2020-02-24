package com.example.giphy.ui.search

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.giphy.R
import com.example.giphy.data.model.SearchData
import com.example.giphy.databinding.FragmentSearchBinding
import com.example.giphy.ui.base.BaseFragment
import com.example.giphy.ui.base.BaseRecyclerAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {

    private lateinit var homeAdapter: HomeAdapter
    private val viewModel: SearchViewModel by viewModel()

    private var offset: Int = 0 // 검색 시작 포지션 위치.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.vm = viewModel
        binding.fragment = this@SearchFragment
        binding.lifecycleOwner = this@SearchFragment

        binding.recycle.run {
            homeAdapter = HomeAdapter(object : BaseRecyclerAdapter.ItemListener<SearchData> {
                override fun loadMoreItems(list: List<SearchData>, index: Int) {
                    offset += 1
                    lifecycleScope.launch {

                    }
                }
            })
            adapter = homeAdapter
        }



        lifecycleScope.launch {
//            Log.v("dksush", "dkshk")
//            offset = 0
//            viewModel.getSearchList(offset)


        }


//        binding.btn.setOnClickListener {
//            (activity as MainActivity).replaceFragment(FavoriteFragment.newInstance())
//
//        }

    }

    fun onBtnSearch(view: View){
        Log.v("dksush", "검색버튼")
        lifecycleScope.launch {
            offset = 0
            viewModel.getSearchList(offset)

        }

    }


    companion object {
        fun newInstance(): SearchFragment {
            return SearchFragment()
        }
    }

}