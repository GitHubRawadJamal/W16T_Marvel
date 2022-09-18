package com.srj.w16t_marvel.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.srj.w16t_marvel.model.network.State
import com.srj.w16t_marvel.util.extensions.hideView
import com.srj.w16t_marvel.util.extensions.loadImageUrl
import com.srj.w16t_marvel.util.extensions.showView
import com.srj.w16t_marvel.view.base.BaseAdapter
import com.srj.w16t_marvel.view.characters.CharactersAdapter
import com.srj.w16t_marvel.view.characters.CharactersViewModel
import com.srj.w16t_marvel.view.home.HomeAdapter
import com.srj.w16t_marvel.view.home.HomeViewModel

@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> showWhenLoading(view: View, state: State<T>?){
    if(state is State.Loading){
        view.showView()
    } else {
        view.hideView() }
}

@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> showWhenSuccess(view: View, state: State<T>?){
    if(state is State.Success){
        view.showView()
    } else {
        view.hideView() }
}

@BindingAdapter(value = ["app:showWhenError"])
fun <T> showWhenError(view: View, state: State<T>?){
    if(state is State.Error){
        view.showView()
    } else {
        view.hideView() }
}

@BindingAdapter(value = ["app:imageUrl"])
fun setImageByUrl(view: ImageView, url: String?){
    if (url != null) {
        with(view) { loadImageUrl(url) }
    }
}


@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?){
    if (items != null) {
        (view.adapter as BaseAdapter<T>?)?.setItems(items)
    } else{
        (view.adapter as BaseAdapter<T>?)?.setItems(emptyList())
    }
}

@BindingAdapter(value = ["app:setCharactersAdapter"])
fun setMarvelCharactersAdapter(view: RecyclerView, viewModel: CharactersViewModel){
    view.adapter = CharactersAdapter(mutableListOf(), viewModel)
}


@BindingAdapter(value = ["app:setHomeAdapter"])
fun setMarvelHomeAdapter(view: RecyclerView, viewModel: HomeViewModel){
    view.adapter = HomeAdapter(mutableListOf(), viewModel)
}
