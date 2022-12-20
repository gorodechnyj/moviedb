package com.gorodechnyj.ui.button

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.view.isVisible
import com.gorodechnyj.core.ui.databinding.CartButtonBinding

class CartButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding: CartButtonBinding =
        CartButtonBinding.inflate(LayoutInflater.from(context), this, true)
    private var clickListener: OnClickListener? = null

    init {
        binding.btnAddToCart.setOnClickListener {
            clickListener?.onAddToCartClicked()
        }
        binding.btnMinus.setOnClickListener {
            clickListener?.onMinusClicked()
        }
        binding.btnPlus.setOnClickListener {
            clickListener?.onPlusClicked()
        }
    }

    fun setAmount(amount: Int) {
        binding.amount.text = amount.toString()
        binding.cartAmountLayout.isVisible = amount > 0
        binding.btnAddToCart.isVisible = amount == 0
    }

    fun setClickListener(listener: OnClickListener?) {
        clickListener = listener
    }

    interface OnClickListener {
        fun onMinusClicked()
        fun onPlusClicked()
        fun onAddToCartClicked()
    }
}
