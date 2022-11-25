package com.example.misrecetasapplication.data.model

import com.example.misrecetasapplication.utils.ResponseBase

/**
 * Created by PercyChávez on 24, November, 2022.
 * Copyright (c) 2022 Llamafood. All rights reserved.
 */
data class ReceiptE(
    var image: String? = "",
    var name: String? = "",
    var description: String? = "",
    var receipt_lat: String? = "",
    var receipt_lng: String? = "",
    var ingredients: String? = ""
){

    fun getIngredientsNotNull(): String
    {
        return if (ingredients != null) ingredients!! else "0.0"
    }

    fun getLatNotNull(): String
    {
        return if (receipt_lat != null) receipt_lat!! else "0.0"
    }

    fun getLngNotNull(): String
    {
        return if (receipt_lng != null) receipt_lng!! else "0.0"
    }

    fun getImgNotNull(): String
    {
        return if (image != null) image!! else ""
    }

    fun getNameStr(): String
    {
        return if (name != null) name!! else ""
    }

    fun getDescriptionStr(): String
    {
        return if (description != null) description!! else ""
    }
}
