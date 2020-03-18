package com.example.giphy.ui.search

import android.content.Context
import android.graphics.Point
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import androidx.recyclerview.widget.DiffUtil
import com.example.giphy.data.model.SearchResponse
import com.example.giphy.databinding.ItemGifBinding
import com.example.giphy.ui.base.BaseRecyclerAdapter
import com.example.giphy.ui.base.BaseViewHolder

class SearchAdapter(
    private val context: Context,
    private val itemListener: ItemListener<SearchResponse>
) :
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

        // 디바이스 크기 측정.
        private val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        private val size = Point().also { wm.defaultDisplay.getSize(it) }
        private var width = 0

        init {
            width = size.x / 2
        }

        override fun bind(item: SearchResponse) {
            // 높이값 반영.
            binding.contentLayout.layoutParams.height =
                getScaleSizeHeight(
                    item.images?.fixed_width_small?.width!!,
                    item.images.fixed_width_small.height,
                    width
                )

            this.item = item
            with(binding) {
                items = item
                setOnClick {
                    itemListener.itemOnClick(item)
                }
                executePendingBindings()
            }
        }

    }
}

private class DiffCallback : DiffUtil.ItemCallback<SearchResponse>() {
    // 두 객체 같은 항목인지 여부
    override fun areItemsTheSame(oldItem: SearchResponse, newItem: SearchResponse): Boolean {
        return oldItem == newItem

    }

    // 두 항목의 데이터가 같은지 여.
    // areItemsTheSame 가 true 반환시에만 호출.
    override fun areContentsTheSame(oldItem: SearchResponse, newItem: SearchResponse): Boolean {
        return oldItem == newItem
    }

}