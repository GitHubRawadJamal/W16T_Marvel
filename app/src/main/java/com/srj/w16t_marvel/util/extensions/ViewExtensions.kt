package com.srj.w16t_marvel.util.extensions

import android.view.View

fun View.hideView(){
    this.visibility = View.GONE
}

fun View.showView(){
    this.visibility = View.VISIBLE
}