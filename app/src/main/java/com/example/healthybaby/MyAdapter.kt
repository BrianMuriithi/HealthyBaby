package com.example.healthybaby

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(private val userlist : ArrayList<User>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {


        val inflatedView = parent.inflate(R.layout.list_item,false)

        return MyViewHolder(inflatedView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val user = userlist[position]

        holder.name.text = user.Name
        holder.age.text = user.Age.toString()
        holder.phone.text = user.phoneNumber.toString()
        holder.address.text = user.Address
        holder.record.text = user.recordID



    }

    override fun getItemCount(): Int {

        return userlist.size
    }

    class MyViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){



        val name: TextView = itemview.findViewById(R.id.tvname)
        val age: TextView = itemview.findViewById(R.id.tvage)
        val phone: TextView = itemview.findViewById(R.id.tvphone)
        val address: TextView = itemview.findViewById(R.id.tvaddress)
        val record:TextView = itemview.findViewById(R.id.tvrecord)


    }






}