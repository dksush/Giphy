package com.example.giphy.ui.detail

import android.os.Bundle
import android.view.View
import com.example.giphy.R
import com.example.giphy.common.LikedItemInfo
import com.example.giphy.common.StringConst
import com.example.giphy.data.model.SearchResponse
import com.example.giphy.databinding.FragmentGifDetailBinding
import com.example.giphy.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class GifDetailFragment : BaseFragment<FragmentGifDetailBinding>(R.layout.fragment_gif_detail) {


    private var searchResponse: SearchResponse? = null
    private val viewModel: GifDetailViewModel by viewModel { parametersOf(searchResponse) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchResponse = this.arguments?.getSerializable(StringConst.INTENT_KEY_GIF_INFO) as SearchResponse?

        LikedItemInfo.SearchResponse.let {
            if (it.contains(searchResponse?.id)) {
                viewModel.isLiked = true
            }
        }
        binding.vm = viewModel
        binding.lifecycleOwner = this


    }

    companion object {
        fun newInstance(): GifDetailFragment {
            return GifDetailFragment()
        }
    }
}