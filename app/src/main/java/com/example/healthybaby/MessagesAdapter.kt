package com.example.healthybaby

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.recyclerview.widget.RecyclerView
import com.example.healthybaby.databinding.MessagesListBinding


class MessagesAdapter (var c:Context,var messageList:ArrayList<MessagesData>
):RecyclerView.Adapter<MessagesAdapter.MessagesViewHolder>()
{
    inner class MessagesViewHolder(var v:MessagesListBinding) : RecyclerView.ViewHolder(v.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<MessagesListBinding>(inflater,R.layout.messages_list,parent,false)
        return MessagesViewHolder(v)
    }

    override fun onBindViewHolder(holder: MessagesViewHolder, position: Int) {
        holder.v.isMessages = messageList[position]

    }

    override fun getItemCount(): Int {
        return messageList.size
    }

}