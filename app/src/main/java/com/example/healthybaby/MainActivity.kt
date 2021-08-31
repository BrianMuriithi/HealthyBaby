package com.example.healthybaby

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)



        val buttonvisitor= findViewById<ImageView>(R.id.imageGallery)
        buttonvisitor.setOnClickListener {
            val intent = Intent(this, Visitor::class.java)
            startActivity(intent)

        }

        val buttonHistory = findViewById<ImageView>(R.id.imageFavorite)
        buttonHistory.setOnClickListener {
            val intent = Intent(this, VisitHistory::class.java)
            startActivity(intent)

        }







    }

}