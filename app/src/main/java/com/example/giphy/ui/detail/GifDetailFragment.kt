package com.example.giphy.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.giphy.R
import com.example.giphy.common.StringConst
import com.example.giphy.data.model.SearchData
import com.example.giphy.databinding.FragmentGifDetailBinding
import com.example.giphy.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf



class GifDetailFragment : BaseFragment<FragmentGifDetailBinding>(R.layout.fragment_gif_detail) {


    private var searchData: SearchData? = null
    private val viewModel: GifDetailViewModel by viewModel { parametersOf(searchData) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.v("dksush", "here3")
        searchData = this.arguments?.getSerializable(StringConst.INTENT_KEY_GIF_INFO) as SearchData?

        Log.v("dksush_asdfasdf", searchData?.id)
       // searchData = arguments.getSerializableExtra(StringConst.INTENT_KEY_GIF_INFO) as SearchData?

//        searchData = context.intent.getSerializableExtra(StringConst.INTENT_KEY_GIF_INFO) as SearchData?


        binding.vm = viewModel
        binding.lifecycleOwner = this







    }
    companion object{
        fun newInstance(): GifDetailFragment {
            Log.v("dksush_companion", "newInstance")
            return GifDetailFragment()
        }
    }
}