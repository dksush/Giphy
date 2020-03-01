package com.example.giphy.ui.favorite

import android.content.Context
import android.graphics.Point
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import androidx.recyclerview.widget.DiffUtil
import com.example.giphy.MainActivity
import com.example.giphy.common.StringConst
import com.example.giphy.data.model.SearchResponse
import com.example.giphy.databinding.ItemGifBinding
import com.example.giphy.ui.base.BaseRecyclerAdapter
import com.example.giphy.ui.base.BaseViewHolder
import com.example.giphy.ui.detail.GifDetailFragment

class FavoriteAdapter(private val context: Context, itemListener: ItemListener<SearchResponse>) :
    BaseRecyclerAdapter<SearchResponse, FavoriteAdapter.FavoriteHolder>(itemListener, DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteHolder {
        return FavoriteHolder(
            ItemGifBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    inner class FavoriteHolder(private val binding: ItemGifBinding) :
        BaseViewHolder<SearchResponse>(binding.root) {

        private lateinit var item: SearchResponse
        private var width: Int = 0

        init {
            binding.setOnClick {
                val gifDetailFragment = GifDetailFragment()
                val bundle = Bundle()
                bundle.putSerializable(StringConst.INTENT_KEY_GIF_INFO, item)
                gifDetailFragment.arguments = bundle
                (context as MainActivity).replaceFragment(gifDetailFragment)
            }

            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val display = wm.defaultDisplay
            val size = Point()
            display.getSize(size)
            width = size.x / 2
        }


        override fun bind(item: SearchResponse) {
            this.item = item
            with(binding) {
                items = item
                executePendingBindings()
            }
        }

    }


}

private class DiffCallback : DiffUtil.ItemCallback<SearchResponse>() {
    override fun areItemsTheSame(oldItem: SearchResponse, newItem: SearchResponse): Boolean {
        return oldItem == newItem

    }

    override fun areContentsTheSame(oldItem: SearchResponse, newItem: SearchResponse): Boolean {
        return oldItem == newItem
    }

}