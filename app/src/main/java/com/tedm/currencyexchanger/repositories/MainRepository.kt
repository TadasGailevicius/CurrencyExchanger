package com.tedm.currencyexchanger.repositories

import com.tedm.currencyexchanger.data.remote.entities.CurrencyRatesResponse
import com.tedm.currencyexchanger.other.Resource

interface MainRepository {

    suspend fun getRates(): Resource<CurrencyRatesResponse>
}