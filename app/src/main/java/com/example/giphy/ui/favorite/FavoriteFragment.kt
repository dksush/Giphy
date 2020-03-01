package com.example.giphy.ui.favorite

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.giphy.R
import com.example.giphy.data.model.SearchResponse
import com.example.giphy.databinding.FragmentFavoriteBinding
import com.example.giphy.ui.base.BaseFragment
import com.example.giphy.ui.base.BaseRecyclerAdapter.ItemListener
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(R.layout.fragment_favorite) {

    private lateinit var favoriteAdapter: FavoriteAdapter
    private val viewModel: FavoriteViewModel by viewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            vm = viewModel
            fragmemt = this@FavoriteFragment
            lifecycleOwner = this@FavoriteFragment

            recycle.run {
                favoriteAdapter = FavoriteAdapter(context, object : ItemListener<SearchResponse> {
                    override fun loadMoreItems(list: List<SearchResponse>, index: Int) {
                    }
                })
                adapter = favoriteAdapter
            }


        }


        // 좋아요 api 테스트.
        lifecycleScope.launch {
            viewModel.getFavoriteItem()
        }
    }


    override fun onStart() {
        super.onStart()
        Log.v("dksush", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v("dksush", "onResume") // 온 리슘은 게속 호출됨
    }

    companion object {
        fun newInstance(): FavoriteFragment {
            Log.v("dksush_companion", "newInstance")
            return FavoriteFragment()
        }
    }
}