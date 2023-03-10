package com.example.dagger222.DB

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DbModel::class], version = 1)
abstract class MainDb:RoomDatabase() {
    abstract fun countryDao():Dao

}