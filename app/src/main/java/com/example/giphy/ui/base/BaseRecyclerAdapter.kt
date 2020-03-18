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

    private val itemList: MutableList<T> = mutableListOf()
    private val newItemList: MutableList<T> = mutableListOf()

    override fun onBindViewHolder(holder: H, position: Int) {
        holder.bind(itemList[position])
        if (position == itemCount - 1 && itemCount >= 10)
            itemListener.loadMoreItems(
                currentList, itemCount
            )
    }


    override fun getItemCount(): Int {
        return itemList.size
    }

    open fun setData(items: List<T>) {
        this.itemList.clear()
        notifyDataSetChanged()
        this.itemList.addAll(items)
        //notifyItemRangeInserted(0, items.size)
        submitList(items)




    }

    open fun setAddData(items: List<T>) {
        this.itemList.addAll(items)
        notifyDataSetChanged()
    }

    open fun clearData() {
        this.itemList.clear()
        notifyDataSetChanged()
    }

    open fun getScaleSizeHeight(
        //  context: Context?,
        width: Int,
        height: Int,
        scaleWidth: Int
    ): Int {
        return height * scaleWidth / width
    }


    interface ItemListener<T> {
        fun loadMoreItems(list: List<T>, itemCount: Int)
        fun itemOnClick(item: T)
    }
}


abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
}