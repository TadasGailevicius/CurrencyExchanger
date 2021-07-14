package com.tedm.currencyexchanger.data.remote

import com.tedm.currencyexchanger.BuildConfig
import com.tedm.currencyexchanger.data.remote.entities.CurrencyRates
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {

    @GET("v1/latest")
    suspend fun getTopHeadlines(
        @Query("access_key")
        access_key: String = BuildConfig.API_KEY
    ) : Response<CurrencyRates>
}