package com.example.giphy.ui.detail

import android.os.Bundle
import android.util.Log
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


    private var SearchResponse: SearchResponse? = null
    private val viewModel: GifDetailViewModel by viewModel { parametersOf(SearchResponse) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SearchResponse = intent.getSerializableExtra(StringConst.INTENT_KEY_GIF_INFO) as SearchResponse?


        binding = DataBindingUtil.setContentView(this, R.layout.activity_gif_detail)
        with(binding) {
            vm = viewModel
            lifecycleOwner = this@GifDetailActivity
        }

    }
}
