package com.example.giphy.ui.favorite

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.giphy.R
import com.example.giphy.databinding.FragmentFavoriteBinding
import com.example.giphy.ui.base.BaseFragment

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(R.layout.fragment_favorite) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }




    companion object{
        fun newInstance(): FavoriteFragment {
            Log.v("dksush_companion", "newInstance")
            return FavoriteFragment()
        }
    }
}