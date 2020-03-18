package com.example.giphy.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.giphy.R
import com.example.giphy.common.StringConst
import com.example.giphy.data.model.SearchResponse
import com.example.giphy.databinding.ActivityGifDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class GifDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGifDetailBinding

    private lateinit var searchResponse: SearchResponse
    private val viewModel: GifDetailViewModel by viewModel { parametersOf(searchResponse) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        searchResponse =
            intent.getSerializableExtra(StringConst.INTENT_KEY_GIF_INFO) as SearchResponse

        if (searchResponse.isLike) {
            viewModel.isLiked = true
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_gif_detail)
        binding.vm = viewModel
        binding.lifecycleOwner = this@GifDetailActivity

    }
}
