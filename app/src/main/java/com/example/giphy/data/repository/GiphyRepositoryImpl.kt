package com.example.giphy.data.repository

import com.example.giphy.data.source.local.GiphyLocaltInterface
import com.example.giphy.data.source.remote.GiphyRemotInterface

class GiphyRepositoryImpl(
    private val giphyRemotInterface: GiphyRemotInterface,
    private val giphyLocaltInterface: GiphyLocaltInterface
) : GiphyRepositoryInterface {
}