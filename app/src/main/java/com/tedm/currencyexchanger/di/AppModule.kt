package com.tedm.currencyexchanger.di

import android.content.Context
import androidx.room.Room
import com.tedm.currencyexchanger.data.local.BalanceDatabase
import com.tedm.currencyexchanger.data.remote.CurrencyApi
import com.tedm.currencyexchanger.other.Constants.Companion.BASE_URL
import com.tedm.currencyexchanger.other.Constants.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideBalanceDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, BalanceDatabase::class.java , DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideBalanceDao(db: BalanceDatabase) = db.balanceDao()

    @Singleton
    @Provides
        fun provideCurrencyApi() : CurrencyApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurrencyApi::class.java)
    }
}