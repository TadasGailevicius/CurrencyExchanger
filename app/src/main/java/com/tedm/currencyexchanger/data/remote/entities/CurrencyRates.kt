package com.tedm.currencyexchanger.data.remote.entities

data class CurrencyRates(
    val base: String,
    val date: String,
    val rates: Rates,
    val success: Boolean,
    val timestamp: Int
)