package com.example.giphy.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.giphy.data.model.SearchData
import com.example.giphy.databinding.ItemSearchBinding
import com.example.giphy.ui.base.BaseRecyclerAdapter
import com.example.giphy.ui.base.BaseViewHolder

class HomeAdapter(itemListener: ItemListener<SearchData>) :
    BaseRecyclerAdapter<SearchData, HomeAdapter.HomeHolder>(itemListener, DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HomeHolder(
        ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    inner class HomeHolder(private val binding: ItemSearchBinding) :
        BaseViewHolder<SearchData>(binding.root) {

        private lateinit var item: SearchData

        //        init {
//            binding.setOnClick {
//                Intent(it.context, WebviewActivity::class.java).apply {
//                    putExtra(StringConst.INTENT_KEY_LINK, item.link)
//                }.run { it.context.startActivity(this) }
//            }
//        }
        override fun bind(item: SearchData) {
            this.item = item
            with(binding) {
                items = item
                executePendingBindings()
            }
        }

    }
}

private class DiffCallback : DiffUtil.ItemCallback<SearchData>() {
    override fun areItemsTheSame(oldItem: SearchData, newItem: SearchData): Boolean {
        return oldItem == newItem

    }

    override fun areContentsTheSame(oldItem: SearchData, newItem: SearchData): Boolean {
        return oldItem == newItem
    }

}