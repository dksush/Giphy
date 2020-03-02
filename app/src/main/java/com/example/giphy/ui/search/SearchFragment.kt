package com.example.giphy.ui.search

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.giphy.R
import com.example.giphy.common.toast
import com.example.giphy.data.model.SearchResponse
import com.example.giphy.databinding.FragmentSearchBinding
import com.example.giphy.ui.base.BaseFragment
import com.example.giphy.ui.base.BaseRecyclerAdapter.ItemListener
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {

    private lateinit var searchAdapter: SearchAdapter
    private val viewModel: SearchViewModel by viewModel()

    private var offset: Int = 0 // 검색 시작 포지션 위치.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            vm = viewModel
            fragment = this@SearchFragment
            lifecycleOwner = this@SearchFragment

            recycle.run {
                searchAdapter = SearchAdapter(context, object : ItemListener<SearchResponse> {
                    override fun loadMoreItems(list: List<SearchResponse>, index: Int) {
                        offset += index
                        lifecycleScope.launch {
                            viewModel.requestAddItem(offset)
                        }
                    }
                })
                adapter = searchAdapter

            }
        }


        // 로컬 디비에 저장된 좋아요 게시물 id값 호출.
        lifecycleScope.launch {
            viewModel.requestLikedItem()
        }


        observeListener()

    }

    fun onBtnSearch() {
        lifecycleScope.launch {
            viewModel.requestSearch()

        }

    }

    private fun observeListener() {
        viewModel.blankInputText.observe(viewLifecycleOwner, Observer {
            requireContext().toast(getString(R.string.blank_search_text))
        })

    }

}