package com.example.misrecetasapplication.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.misrecetasapplication.R
import com.example.misrecetasapplication.data.model.ReceiptE
import com.example.misrecetasapplication.databinding.ItemRecipeBinding

/**
 * Created by PercyChávez on 24, November, 2022.
 * Copyright (c) 2022 Llamafood. All rights reserved.
 */
class HomeReceiptAdapter(
    var receipts: MutableList<ReceiptE>,
    var onClick: onClickItemRecipe
):  RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface onClickItemRecipe {
        fun onClick(item: ReceiptE)
        fun onClickImage(item: ReceiptE)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ItemRecipeHolder(
            layoutInflater.inflate(R.layout.item_recipe, parent, false),
            onClick
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val receipt = receipts[position]
        if (holder is ItemRecipeHolder) {
            if (holder != null) {
                holder.render(receipt)
            }
        }
    }

    override fun getItemCount(): Int {
        return receipts.size
    }

    fun addAllItems(newReceipts: MutableList<ReceiptE>){
        receipts.clear()
        receipts.addAll(newReceipts)
        notifyDataSetChanged()
    }

}