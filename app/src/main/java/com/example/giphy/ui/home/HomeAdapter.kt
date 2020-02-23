package com.example.giphy.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.giphy.data.model.HomeData
import com.example.giphy.databinding.ItemHomeBinding
import com.example.giphy.ui.base.BaseRecyclerAdapter
import com.example.giphy.ui.base.BaseViewHolder

class HomeAdapter : BaseRecyclerAdapter<HomeData, HomeAdapter.HomeHolder>(DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HomeHolder(
        ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    inner class HomeHolder(private val binding: ItemHomeBinding) :
        BaseViewHolder<HomeData>(binding.root) {

        private lateinit var item: HomeData

        //        init {
//            binding.setOnClick {
//                Intent(it.context, WebviewActivity::class.java).apply {
//                    putExtra(StringConst.INTENT_KEY_LINK, item.link)
//                }.run { it.context.startActivity(this) }
//            }
//        }
        override fun bind(item: HomeData) {
            this.item = item
            with(binding) {
                items = item
                executePendingBindings()
            }
        }

    }
}

private class DiffCallback : DiffUtil.ItemCallback<HomeData>() {
    override fun areItemsTheSame(oldItem: HomeData, newItem: HomeData): Boolean {
        return oldItem == newItem

    }

    override fun areContentsTheSame(oldItem: HomeData, newItem: HomeData): Boolean {
        return oldItem == newItem
    }

}