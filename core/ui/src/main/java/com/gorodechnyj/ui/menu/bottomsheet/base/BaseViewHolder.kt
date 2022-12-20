package com.gorodechnyj.ui.menu.bottomsheet.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<M>(val viewDataBinding: ViewBinding) : RecyclerView.ViewHolder(viewDataBinding.root) {
    abstract fun bind(position: Int, item: M?)

    @Suppress("UNCHECKED_CAST")
    inline fun <T : ViewBinding> bind(binding: T.() -> Unit) {
        binding(viewDataBinding as T)
    }
}
