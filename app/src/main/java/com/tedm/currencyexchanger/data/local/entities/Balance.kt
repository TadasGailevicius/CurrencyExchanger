package com.tedm.currencyexchanger.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "balances")
data class Balance (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val sum: Double,
    val currencyCode: String,
)
