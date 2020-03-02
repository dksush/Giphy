package com.example.giphy.ui.search

import android.content.Context
import android.content.Intent
import android.graphics.Point
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import androidx.recyclerview.widget.DiffUtil
import com.example.giphy.common.StringConst
import com.example.giphy.data.model.SearchResponse
import com.example.giphy.databinding.ItemGifBinding
import com.example.giphy.ui.base.BaseRecyclerAdapter
import com.example.giphy.ui.base.BaseViewHolder
import com.example.giphy.ui.detail.GifDetailActivity

class SearchAdapter(private val context: Context, itemListener: ItemListener<SearchResponse>) :
    BaseRecyclerAdapter<SearchResponse, SearchAdapter.SearchHolder>(itemListener, DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder {
        return SearchHolder(
            ItemGifBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class SearchHolder(private val binding: ItemGifBinding) :
        BaseViewHolder<SearchResponse>(binding.root) {

        private lateinit var item: SearchResponse
        private val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        private val size = Point().also {
            wm.defaultDisplay.getSize(it)
        }
        private var width = 0

        init {
            binding.setOnClick {
                Intent(it.context, GifDetailActivity::class.java).apply {
                    putExtra(StringConst.INTENT_KEY_GIF_INFO, item)
                }.run { it.context.startActivity(this) }

            }
            width = size.x / 2

        }

        override fun bind(item: SearchResponse) {
            // 높이값 지정.
            binding.contentLayout.layoutParams.height =
                getScaleSizeHeight(
                    item.images?.fixed_width_small?.width!!,
                    item.images.fixed_width_small.height,
                    width
                )

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