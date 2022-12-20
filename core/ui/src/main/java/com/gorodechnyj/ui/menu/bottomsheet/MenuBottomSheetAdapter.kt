package com.gorodechnyj.ui.menu.bottomsheet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gorodechnyj.core.ui.databinding.BottomSheetMenuItemBinding
import com.gorodechnyj.ui.menu.bottomsheet.base.BaseAdapter
import com.gorodechnyj.ui.menu.bottomsheet.base.BaseViewHolder

class MenuBottomSheetAdapter :
    BaseAdapter<MenuBottomSheetItem, MenuBottomSheetAdapter.MenuBottomSheetViewHolder>() {

    class MenuBottomSheetViewHolder(viewDataBinding: BottomSheetMenuItemBinding) :
        BaseViewHolder<MenuBottomSheetItem>(viewDataBinding) {

        override fun bind(position: Int, item: MenuBottomSheetItem?) {
            return bind<BottomSheetMenuItemBinding> {
                this.textView.text = item?.title
                item?.iconRes?.let { this.icon.setImageResource(it) }
                item?.iconDrawable?.let { this.icon.setImageDrawable(it) }
                this.icon.visibility =
                    if (item?.iconDrawable == null && item?.iconRes == null) View.GONE else View.VISIBLE
            }
        }
    }

    override fun getViewHolder(parent: ViewGroup, viewType: Int): MenuBottomSheetViewHolder {
        return MenuBottomSheetViewHolder(
            BottomSheetMenuItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}
