package org.cream.udemshoppingproject.ui.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import org.cream.udemshoppingproject.GlideApp

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl:String?) {
    if(!imageUrl.isNullOrEmpty()){
        GlideApp.with(view)
            .load(imageUrl)
            .into(view)
    }
}