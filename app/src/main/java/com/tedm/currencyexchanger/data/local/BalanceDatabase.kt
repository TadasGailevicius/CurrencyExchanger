package com.tedm.currencyexchanger.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tedm.currencyexchanger.data.local.entities.Balance

@Database(
    entities = [Balance::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class BalanceDatabase  : RoomDatabase() {

    abstract fun balanceDao(): BalanceDao
}