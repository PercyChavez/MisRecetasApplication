package com.example.misrecetasapplication.data.model

import com.example.misrecetasapplication.utils.ResponseBase

/**
 * Created by PercyChávez on 24, November, 2022.
 * Copyright (c) 2022 Llamafood. All rights reserved.
 */
data class ReceiptResponse(
    var receipts: MutableList<ReceiptE> = mutableListOf()
): ResponseBase()