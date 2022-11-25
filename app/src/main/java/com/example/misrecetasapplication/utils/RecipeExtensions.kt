package com.example.misrecetasapplication.utils

import android.widget.ImageView
import coil.load
import coil.transform.RoundedCornersTransformation

/**
 * Created by PercyChávez on 24, November, 2022.
 * Copyright (c) 2022 Llamafood. All rights reserved.
 */


fun ImageView.loadReceiptImg(url: String){
    this.load(url) {
        placeholder(com.example.misrecetasapplication.R.mipmap.ic_loader)
        error(com.example.misrecetasapplication.R.mipmap.ic_loader)
        transformations(RoundedCornersTransformation(20f))
    }
}