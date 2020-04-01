package com.example.giphy.ui.base

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T, H : BaseViewHolder<T>>(
    private val itemListener: ItemListener<T>,
    diffCallback: DiffUtil.ItemCallback<T>
) :
    ListAdapter<T, H>(diffCallback) {

    override fun onBindViewHolder(holder: H, position: Int) {
        holder.bind(getItem(position))
        if (position == itemCount - 1 && itemCount >= 10)
            itemListener.loadMoreItems(
                itemCount
            )
    }

    fun setData(items: List<T>) {
        submitList(items)
    }

    fun clearData() {
        currentList.clear()
        submitList(null)
    }

    fun getScaleSizeHeight(
        //  context: Context?,
        width: Int,
        height: Int,
        scaleWidth: Int
    ): Int {
        return height * scaleWidth / width
    }


    interface ItemListener<T> {
        fun loadMoreItems(itemCount: Int)
        fun itemOnClick(item: T)
    }
}


abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
}