package com.example.dagger222

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger222.DB.DbModel
import com.example.dagger222.ViewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var recyclerI:RecyclerView
    lateinit var mainViewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
recyclerI=findViewById(R.id.recyclers)
        mainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)
if (isNetworkConnect(this)){
    mainViewModel.getCountriesFromApi()
}else{
    Toast.makeText(this,"No INTERNER",Toast.LENGTH_LONG).show()
}
        mainViewModel.getAllCountryLisy().observe(this, Observer<List<DbModel>>{countryList->

            setUPContry(countryList!!)
        })

    }

    fun isNetworkConnect(context: Context):Boolean{
        val cm=context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activityNetwork=cm.activeNetworkInfo
        return activityNetwork !=null && activityNetwork.isConnectedOrConnecting
    }

    fun setUPContry(contrise:List<DbModel>){
val adapter=RecyclerAdapter(this,contrise)
        recyclerI.adapter=adapter
        recyclerI.layoutManager=LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
        recyclerI.setHasFixedSize(true)
    }
 }