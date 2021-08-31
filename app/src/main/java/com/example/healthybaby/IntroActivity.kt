package com.example.healthybaby

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity



class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val button= findViewById<Button>(R.id.startbutton)
        button.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)

        }

    }
}