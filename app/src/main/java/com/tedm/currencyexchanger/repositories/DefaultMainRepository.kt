package com.tedm.currencyexchanger.repositories

import android.app.Application
import com.tedm.currencyexchanger.data.local.BalanceDao
import com.tedm.currencyexchanger.data.remote.CurrencyApi
import com.tedm.currencyexchanger.data.remote.entities.CurrencyRatesResponse
import com.tedm.currencyexchanger.other.Resource
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val balanceDao: BalanceDao,
    private val currencyApi: CurrencyApi,
    private val context: Application
) : MainRepository {

    override suspend fun getRates(): Resource<CurrencyRatesResponse> {
        return try {
            val response = currencyApi.getRates()
            val result = response.body()
            if(response.isSuccessful && result != null) {
                Resource.success(result)
            } else {
                Resource.error(response.message(), null)
            }
        } catch(e: Exception) {
            Resource.error(e.message ?: "An error occured", null)
        }
    }
}