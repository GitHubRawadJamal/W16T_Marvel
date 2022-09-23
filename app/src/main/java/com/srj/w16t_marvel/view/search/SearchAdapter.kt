package com.srj.w16t_marvel.view.search

import com.srj.w16t_marvel.R
import com.srj.w16t_marvel.view.base.BaseAdapter

class SearchAdapter(items: List<Character>, listener: SearchInteractionListener):
    BaseAdapter<Character>(items, listener) {
    override val layoutID: Int = R.layout.item_search
}