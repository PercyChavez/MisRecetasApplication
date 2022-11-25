package com.example.misrecetasapplication.data.repository

import com.example.misrecetasapplication.data.model.ReceiptResponse
import com.example.misrecetasapplication.data.network.home.HomeService

/**t
 * Created by PercyChávez on 24, November, 2022.
 * Copyright (c) 2022 Llamafood. All rights reserved.
 */
class HomeRepository {
    private var service = HomeService()

    suspend fun getReceipts(): ReceiptResponse = service.getReceipts()

}