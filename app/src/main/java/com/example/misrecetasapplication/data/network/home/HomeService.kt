package com.example.misrecetasapplication.data.network.home

import com.example.misrecetasapplication.data.model.ReceiptResponse
import com.example.misrecetasapplication.utils.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by PercyChávez on 24, November, 2022.
 * Copyright (c) 2022 Llamafood. All rights reserved.
 */
class HomeService {
    private var retrofit = RetrofitHelper.getRetrofit()

    suspend fun getReceipts(): ReceiptResponse {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(HomeApiClient::class.java)
                .getManualDepositApiClient()
            response
        }
    }
}