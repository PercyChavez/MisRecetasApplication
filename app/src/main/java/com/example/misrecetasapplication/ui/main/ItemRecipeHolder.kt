package com.example.misrecetasapplication.ui.main

import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.misrecetasapplication.data.model.ReceiptE
import com.example.misrecetasapplication.databinding.ItemRecipeBinding
import com.example.misrecetasapplication.utils.loadReceiptImg

/**
 * Created by PercyChávez on 24, November, 2022.
 * Copyright (c) 2022 Llamafood. All rights reserved.
 */
class ItemRecipeHolder(var view: View, var onClick: HomeReceiptAdapter.onClickItemRecipe): RecyclerView.ViewHolder(view) {

    private val binding = ItemRecipeBinding.bind(view)

    @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
    fun render(item: ReceiptE) {
        binding.itemImg.loadReceiptImg(item.getImgNotNull())
        binding.itemName.text = item.getNameStr()
        binding.cardData.setOnClickListener {
            onClick.onClick(item)
        }
        binding.itemImg.setOnClickListener {
            onClick.onClickImage(item)
        }
    }

}