package com.example.giphy.common

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.giphy.R
import com.example.giphy.ui.base.BaseRecyclerAdapter
import com.example.giphy.ui.base.BaseViewHolder
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView


@SuppressLint("ShowToast")
fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

}

@BindingAdapter("htmlText")
fun TextView.changeHtmlText(text: String) {
    this.text = HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_COMPACT)
}

@BindingAdapter("bindImage")
fun bindImage(view: ImageView, res: String) {
    Glide.with(view.context)
        .load(res)
        .into(view)
}


@BindingAdapter("bindGlideGif")
fun bindGlideGif(view: ImageView, res: String?) {
    Glide.with(view.context)
        .asGif()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .placeholder(R.drawable.ic_launcher_foreground)
        .error(R.drawable.ic_launcher_foreground)
        .load(res)
        .into(view)

}


@BindingAdapter("bindFrescoGif")
fun bindFrescoGif(view: SimpleDraweeView, res: String?) {
    view.controller = Fresco.newDraweeControllerBuilder()
        .setUri(res)
        .setAutoPlayAnimations(true)
        .build()
}


@BindingAdapter("bindImageUri")
fun bindImageUri(view: ImageView, res: String) {
    view.setImageURI(Uri.parse(res))
}


@Suppress("UNCHECKED_CAST")
@BindingAdapter("setData")
fun RecyclerView.setData(items: List<Any>?) {
    (this.adapter as? BaseRecyclerAdapter<Any, BaseViewHolder<Any>>)?.run {
        if (items != null) {
            setData(items)
        } else {
            clearData()
        }
    }
}

//@Suppress("UNCHECKED_CAST")
//@BindingAdapter("setAddData")
//fun RecyclerView.setAddData(items: List<Any>?) {
//    (this.adapter as? BaseRecyclerAdapter<Any, BaseViewHolder<Any>>)?.run {
//        items?.let {
//            setAddData(items)
//        }
//    }
//}
