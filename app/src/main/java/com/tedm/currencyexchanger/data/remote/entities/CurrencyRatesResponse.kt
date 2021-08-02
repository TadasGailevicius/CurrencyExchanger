package com.tedm.currencyexchanger.data.remote.entities

data class CurrencyRatesResponse(
    val base: String,
    val date: String,
    val rates: Rates,
    val success: Boolean,
    val timestamp: Int
)