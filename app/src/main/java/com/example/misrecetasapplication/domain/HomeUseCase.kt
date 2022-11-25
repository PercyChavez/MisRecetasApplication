package com.example.misrecetasapplication.domain

import com.example.misrecetasapplication.data.model.ReceiptResponse
import com.example.misrecetasapplication.data.repository.HomeRepository

/**
 * Created by PercyChávez on 24, November, 2022.
 * Copyright (c) 2022 Llamafood. All rights reserved.
 */
class HomeUseCase  {
    private val  repo = HomeRepository()
    suspend fun getReceipts(): ReceiptResponse = repo.getReceipts()

}