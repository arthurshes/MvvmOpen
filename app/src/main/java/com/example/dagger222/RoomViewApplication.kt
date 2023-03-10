package com.example.dagger222

import android.app.Application
import androidx.room.Room
import com.example.dagger222.DB.MainDb

class RoomViewApplication:Application() {
    companion object{
        var database:MainDb?=null
    }

    override fun onCreate() {
        super.onCreate()
        database=Room.databaseBuilder(applicationContext,MainDb::class.java,"country.db").fallbackToDestructiveMigration().build()
    }
}