package com.example.healthybaby


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class login : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    var mAuthListener: FirebaseAuth.AuthStateListener? = null


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        firebaseAuth = FirebaseAuth.getInstance()
        mAuthListener = FirebaseAuth.AuthStateListener {
            val user = Firebase.auth.currentUser
            if (user != null) {
                startActivity(Intent(this, MainActivity::class.java))
            }else{
                loginUser()
            }
        }




        val loginBtn = findViewById<Button>(R.id.loginBtn)


        loginBtn.setOnClickListener {
            loginUser()
        }


    }

    private fun loginUser() {
        val email = findViewById<EditText>(R.id.editTextEmail)
        val password = findViewById<EditText>(R.id.editTextpassword)
        val etemail = email .text. toString ().trim()
        val etpassword=password.text.toString().trim()

        when {
            TextUtils.isEmpty(etemail) -> {
                email.error = "Email Cannot Be Empty"
                email.requestFocus()
            }
            TextUtils.isEmpty(etpassword) -> {
                password.error = "Password Cannot Be Empty"
                password.requestFocus()
            }
            else -> {
                firebaseAuth.signInWithEmailAndPassword(etemail, etpassword).addOnCompleteListener(this){
                    if(it.isSuccessful) {
                        Toast.makeText(this,  "Authentication Successfull", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }else{
                        Toast.makeText(this,  "Authentication Failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}



