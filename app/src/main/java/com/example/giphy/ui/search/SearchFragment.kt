package com.example.giphy.ui.search

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.giphy.MainViewModel
import com.example.giphy.R
import com.example.giphy.common.StringConst
import com.example.giphy.common.toast
import com.example.giphy.data.model.SearchResponse
import com.example.giphy.databinding.FragmentSearchBinding
import com.example.giphy.ui.base.BaseFragment
import com.example.giphy.ui.base.BaseRecyclerAdapter.ItemListener
import com.example.giphy.ui.detail.GifDetailActivity
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {

    private lateinit var searchAdapter: SearchAdapter

    private val viewModel: SearchViewModel by viewModel()
    private val mainViewModel: MainViewModel by activityViewModels()

    private var searchStartIndex: Int = 0 // 검색 시작 포지션 위치.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            vm = viewModel
            fragment = this@SearchFragment
            lifecycleOwner = this@SearchFragment

            recycle.run {
                searchAdapter = SearchAdapter(context, object : ItemListener<SearchResponse> {
                    override fun loadMoreItems(itemCount: Int) {
                        searchStartIndex = itemCount
                        lifecycleScope.launch {
                            viewModel.requestAddItem(searchStartIndex)
                        }
                    }
                    override fun itemOnClick(item: SearchResponse) {
                        item.isLike = viewModel.likedItemInfo.contains(item.id)
                        Intent(activity, GifDetailActivity::class.java).apply {
                            putExtra(StringConst.INTENT_KEY_GIF_INFO, item)
                        }.run { startActivity(this) }
                    }
                })
                adapter = searchAdapter

            }
        }

        // 로컬디비 observe(좋아요 리스트)
        mainViewModel.likedItemInfo.observe(viewLifecycleOwner, Observer {
            viewModel.likedItemInfo = it.toHashSet()
        })

        // 키보드 엔터 변경.
        binding.editText.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                lifecycleScope.launch {
                    viewModel.requestSearch()
                }
                true
            } else {
                false
            }
        }

        observeListener()

    }

    fun onBtnSearch() {
        // lifecycleScope 의 컨텍스트가(서치프래그) 가 destroy 될 때, 자동으로 해당 블ㄹ럭안의 코드를 취소한다.
        // 다만 UI 스레드에서 하는게 아니라면 100퍼센트 보장이 되진 않는다.
        lifecycleScope.launch {
            viewModel.requestSearch()

        }

    }

    private fun observeListener() {
        viewModel.blankInputText.observe(viewLifecycleOwner, Observer {
            requireContext().toast(getString(R.string.blank_search_text))
        })
        viewModel.errorToast.observe(viewLifecycleOwner, Observer {
            requireContext().toast(getString(R.string.server_not_respond_text))
        })
        viewModel.nonResult.observe(viewLifecycleOwner, Observer {
            requireContext().toast(getString(R.string.non_result_text))
        })


    }

}