package com.example.movieapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.net.PasswordAuthentication

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
    }
    private fun initUi(){
        button.setOnClickListener {
            val email = editText2.text.toString()
            val password = editText.text.toString()
            saveUser(email,password)
            navigateDetailActivity()

        }
    }

    private fun navigateDetailActivity(){
        val detailIntent = Intent(this, MovieDetailActivity::class.java)
        startActivity(detailIntent)
    }

    private fun saveUser(email: String,password: String){
        val preferences = getSharedPreferences("MovieApp", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString("email",email)
        editor.putString("password",password)
        editor.apply()


    }
}

