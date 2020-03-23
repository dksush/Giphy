package com.example.giphy.ui.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.giphy.MainViewModel
import com.example.giphy.R
import com.example.giphy.common.StringConst
import com.example.giphy.data.model.SearchResponse
import com.example.giphy.databinding.FragmentFavoriteBinding
import com.example.giphy.ui.base.BaseFragment
import com.example.giphy.ui.base.BaseRecyclerAdapter.ItemListener
import com.example.giphy.ui.detail.GifDetailActivity
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(R.layout.fragment_favorite) {

    private lateinit var favoriteAdapter: FavoriteAdapter

    private val viewModel: FavoriteViewModel by viewModel()
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            vm = viewModel
            fragmemt = this@FavoriteFragment
            lifecycleOwner = this@FavoriteFragment

            recycle.run {
                favoriteAdapter = FavoriteAdapter(context, object : ItemListener<SearchResponse> {
                    override fun loadMoreItems(index: Int) {
                    }

                    override fun itemOnClick(item: SearchResponse) {
                        item.isLike = true
                        Intent(activity, GifDetailActivity::class.java).apply {
                            putExtra(StringConst.INTENT_KEY_GIF_INFO, item)
                        }.run { startActivity(this) }
                    }

                })
                adapter = favoriteAdapter
            }
        }

        // 로컬디비 observe(좋아요 리스트)
        mainViewModel.likedItemInfo.observe(viewLifecycleOwner, Observer {
            viewModel.likedItemInfo = it.toHashSet()

            lifecycleScope.launch {
                viewModel.getFavoriteItem()
            }
        })
    }

}