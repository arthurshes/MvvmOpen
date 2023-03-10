package com.example.dagger222.Repo

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.dagger222.Api.RestApi
import com.example.dagger222.DB.DbModel
import com.example.dagger222.RoomViewApplication
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainRepo {
    val BASE_URL="https://restcountries.eu/rest/v2/"
    val TAG=MainRepo::class.java.simpleName

    fun getCountres():LiveData<List<DbModel>>{
        return RoomViewApplication.database!!.countryDao().geAllCountres()
    }

    fun ApiCall(){
        val gson=Gson()
        val retrofit=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val restApi=retrofit.create(RestApi::class.java)

        restApi.getAllCountres().enqueue(object :Callback<List<DbModel>>{
            override fun onFailure(call: Call<List<DbModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<List<DbModel>>, response: Response<List<DbModel>>) {
      Log.e(TAG,"Error repo")
                when(response.code())
                {
                    200->{
                        Thread(Runnable {

                            RoomViewApplication.database!!.countryDao().deleteAllCountres()
                            RoomViewApplication.database!!.countryDao().insertAllCountres(response.body()!!)
                        }).start()
                    }
                }
            }

        })
    }
}