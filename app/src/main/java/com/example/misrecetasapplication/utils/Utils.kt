package com.example.misrecetasapplication.utils

import android.content.Context
import com.example.misrecetasapplication.data.model.ReceiptE
import com.example.misrecetasapplication.data.model.ReceiptResponse
import com.google.gson.Gson

/**
 * Created by PercyChávez on 24, November, 2022.
 * Copyright (c) 2022 Llamafood. All rights reserved.
 */
object Utils {

    fun toJson(clazz: Any?): String {
        val gson = Gson()
        return gson.toJson(clazz)
    }

    fun <T> fromJson(json: String?, clazz: Class<T>?): T {
        val gson = Gson()
        return gson.fromJson(json, clazz)
    }

    fun getStringPreferences(context: Context?, prefKey: String?): String? {
        try {
            if (context != null) {
                val preferences = context.getSharedPreferences(Constants.RECEIPTS_PREF, Context.MODE_PRIVATE)
                return preferences.getString(prefKey, "")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ""
    }

    @JvmStatic
    fun saveStringPreferences(context: Context?, prefKey: String?, prefValue: String?) {
        if (context != null) {
            val editor = context.getSharedPreferences(Constants.RECEIPTS_PREF, Context.MODE_PRIVATE).edit()
            editor.putString(prefKey, prefValue)
            editor.apply()
        }
    }

    fun getLocalReceipts(context: Context?): MutableList<ReceiptE> {
        var user: MutableList<ReceiptE> = mutableListOf()
        val userString = getStringPreferences(context, Constants.RECEIPTS_LIST)
        if (userString != null && userString.isNotEmpty()) {
            user = fromJson(userString, ReceiptResponse::class.java).receipts
        }
        return user
    }

}