package com.example.dagger222.DB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entitest")
data class DbModel (

    @PrimaryKey
    var name:String,
    var capital:String,
    var population:Int,
    var flag:String
        )