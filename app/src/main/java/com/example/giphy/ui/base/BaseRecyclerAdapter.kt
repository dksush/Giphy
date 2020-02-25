package com.example.giphy.ui.base

import android.content.Context
import android.util.Log
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

    override fun onBindViewHolder(holder: H, position: Int) {
        holder.bind(itemList[position])



//        if(position>= firstCompletlyVisibleItem && position<= lastCompletlyVisibleItem){
//            Log.e("visibleItem","position : $position")
//        }




        Log.v("dksush_po", "onBindViewHolder")
//        if (position == itemCount - 1 && itemCount >= 10)
//            itemListener.loadMoreItems(
//            currentList, itemCount + 1
//        )
    }


    override fun getItemCount(): Int {
        return itemList.size
    }

    open fun setData(items: List<T>) {
        Log.v("dksush", "setData")
        this.itemList.clear()
        this.itemList.addAll(items)
        submitList(items)

    }

    open fun setLoadMoreData(items: List<T>) {
        this.itemList.addAll(items)
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
        fun loadMoreItems(list: List<T>, index: Int)
    }
}


abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
}