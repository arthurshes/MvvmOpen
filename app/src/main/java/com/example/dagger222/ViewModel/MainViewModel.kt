package com.example.dagger222.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.dagger222.DB.DbModel
import com.example.dagger222.Repo.MainRepo

class MainViewModel:ViewModel() {
    lateinit var mainRepo: MainRepo

    init {
        mainRepo= MainRepo()
    }

    fun getAllCountryLisy():LiveData<List<DbModel>>{
        return mainRepo.getCountres()
    }

    fun getCountriesFromApi(){
        mainRepo.ApiCall()
    }
}