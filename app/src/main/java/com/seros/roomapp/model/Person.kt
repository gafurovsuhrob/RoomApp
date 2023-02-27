package com.seros.roomapp.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_table")
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstname: String,
    val lastName: String,
    val age: Int,
    @Embedded
    val address: Address
)

data class Address(
    val streetName: String,
    val streetNumber: Int
)