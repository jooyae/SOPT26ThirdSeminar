package com.example.practicesecond

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class InstaAdapter (private val context:Context):RecyclerView.Adapter<InstaViewHolder>(){
    var datas = mutableListOf<InstaData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_insta,parent,false    )
        return InstaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: InstaViewHolder, position: Int) {
       holder.bind(datas[position])
    }
}