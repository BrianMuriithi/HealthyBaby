package com.example.healthybaby

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*


class VisitHistory : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var recyclerView: RecyclerView
    private lateinit var userActivity:ArrayList<User>
    private lateinit var myAdapter: MyAdapter
    private lateinit var db: FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.visit_history)



        recyclerView = findViewById(R.id.recyclerView)

        linearLayoutManager= LinearLayoutManager(this)

        recyclerView.setHasFixedSize(true)

        userActivity = arrayListOf()

        myAdapter = MyAdapter(userActivity)

        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = linearLayoutManager

       if(userActivity.size == 0){
           userActivity.add(element = User())

       }




        eventChangeListener()





    }

    private fun eventChangeListener() {


        db = FirebaseFirestore.getInstance()
        db.collection("Users").orderBy("lastvisit",Query.Direction.DESCENDING).
                addSnapshotListener(object : EventListener<QuerySnapshot>{
                    @SuppressLint("NotifyDataSetChanged")
                    override fun onEvent(
                        value: QuerySnapshot?,
                        error: FirebaseFirestoreException?
                    ) {

                        if(error != null){

                            Log.e("Firestone Error",error.message.toString() )
                            return
                        }

                        for(dc : DocumentChange in value?.documentChanges!!){

                            if(dc.type == DocumentChange.Type.ADDED){

                                userActivity.add(dc.document.toObject(User::class.java))
                            }
                        }

                        myAdapter.notifyDataSetChanged()

                    }




                })






    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onStart() {
        super.onStart()
        myAdapter.notifyDataSetChanged()
    }


}