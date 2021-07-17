package com.tedm.currencyexchanger.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tedm.currencyexchanger.data.local.entities.Balance
import kotlinx.coroutines.flow.Flow

@Dao
interface BalanceDao {

    @Query("SELECT * FROM balances")
    fun getAllBalances(): Flow<List<Balance>>

    @Query("DELETE FROM balances")
    suspend fun deleteAllBalances()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBalance(balance: Balance)

    @Query("UPDATE balances SET sum = :sum WHERE currencyCode = :currencyCode")
    fun updateBalance(sum: Double, currencyCode: String): LiveData<Balance>

    @Query("SELECT * FROM balances WHERE id = :balanceID")
    fun observeBalanceById(balanceID: Int): LiveData<Balance>
}