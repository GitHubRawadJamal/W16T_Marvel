package com.srj.w16t_marvel.util.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.srj.w16t_marvel.R

fun ImageView.loadImageUrl(imageUrl : String){
    Glide.with(this.context).load(imageUrl)
        .centerCrop()
        .placeholder(R.drawable.ic_placeholder_image)
        .error(R.drawable.ic_error)
        .into(this)
}