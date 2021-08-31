package com.example.healthybaby

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.healthybaby.databinding.MessagesBinding
import com.google.firebase.database.*



class Messages : AppCompatActivity() {
    lateinit var mDataBase:DatabaseReference
    private lateinit var messageList:ArrayList<MessagesData>
    private lateinit var mAdapter:MessagesAdapter
    private lateinit var binding:MessagesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.messages)


        messageList = ArrayList()
        mAdapter = MessagesAdapter(this,messageList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = mAdapter

        getMessagesData()



    }

    private fun getMessagesData() {
        mDataBase = FirebaseDatabase.getInstance().getReference("Messages")
        mDataBase.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(messageSnapshot in snapshot.children){
                        val message = messageSnapshot.getValue(MessagesData::class.java)
                        messageList.add(message!!)
                    }
                    binding.recyclerView.adapter = mAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Messages,error.message, Toast.LENGTH_SHORT).show()
            }

        })
    }



}