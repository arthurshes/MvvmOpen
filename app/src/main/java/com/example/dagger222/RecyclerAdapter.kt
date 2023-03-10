package com.example.dagger222

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger222.DB.DbModel
import org.w3c.dom.Text

class RecyclerAdapter(_context: Context,_countryList:List<DbModel>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val context = _context
    val countryList = _countryList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
    return countryList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       if (holder is Countryviewholder){
           holder.bind(countryList[position])
       }
    }
    class Countryviewholder(itemView:View):RecyclerView.ViewHolder(itemView){
        var textCount:TextView=itemView.findViewById(R.id.textViewCoun)
        var textpopiu:TextView=itemView.findViewById(R.id.textViewPopu)
        var textCapit:TextView=itemView.findViewById(R.id.textViewCapital)
        fun bind(dbk:DbModel){
            textCapit.text=dbk.capital
            textpopiu.text=dbk.population.toString()
            textCount.text=dbk.name
        }
    }
}