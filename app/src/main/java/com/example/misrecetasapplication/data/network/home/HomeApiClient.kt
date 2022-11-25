package com.example.misrecetasapplication.data.network.home

import com.example.misrecetasapplication.data.model.ReceiptResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by PercyChávez on 24, November, 2022.
 * Copyright (c) 2022 Llamafood. All rights reserved.
 */
interface HomeApiClient {

    @GET("test_recipe")
    suspend fun getManualDepositApiClient(): ReceiptResponse

}