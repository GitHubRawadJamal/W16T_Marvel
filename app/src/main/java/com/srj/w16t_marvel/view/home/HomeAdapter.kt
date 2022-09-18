package com.srj.w16t_marvel.view.home

import com.srj.w16t_marvel.R
import com.srj.w16t_marvel.view.base.BaseAdapter

class HomeAdapter(items: List<Character>, listener: HomeInteractionListener):
    BaseAdapter<Character>(items, listener) {
    override val layoutID: Int = R.layout.item_character_in_home
}