package com.srj.w16t_marvel.view.characters

import com.srj.w16t_marvel.R
import com.srj.w16t_marvel.view.base.BaseAdapter

class CharactersAdapter(items: List<Character>, listener: CharactersInteractionListener):
    BaseAdapter<Character>(items, listener) {
    override val layoutID: Int = R.layout.item_character
}