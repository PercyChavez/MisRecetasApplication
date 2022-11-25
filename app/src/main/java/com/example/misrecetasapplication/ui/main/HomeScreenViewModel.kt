package com.example.misrecetasapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.misrecetasapplication.data.model.ReceiptE
import com.example.misrecetasapplication.domain.HomeUseCase
import kotlinx.coroutines.launch

/**
 * Created by PercyChávez on 24, November, 2022.
 * Copyright (c) 2022 Llamafood. All rights reserved.
 */

class HomeScreenViewModel : ViewModel() {

    private var homeUseCase = HomeUseCase()

    private val _receipts = MutableLiveData<MutableList<ReceiptE>>()
    val receipts: LiveData<MutableList<ReceiptE>> = _receipts

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    fun getAllReceipts(){
        viewModelScope.launch {
//            try {
//
//            }catch (e: Error){
//
//            }
            val response = homeUseCase.getReceipts()
            if (response.status == "OK"){
                _receipts.value = response.receipts
            }else{
                _message.value = response.message
            }
        }
    }

}