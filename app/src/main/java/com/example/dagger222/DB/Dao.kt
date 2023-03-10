package com.example.dagger222.DB
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCountres(countryList:List<DbModel>)

    @Query("SELECT * FROM entitest")
    fun geAllCountres():LiveData<List<DbModel>>

    @Query("DELETE FROM entitest")
    fun deleteAllCountres()
}