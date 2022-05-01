package com.example.trend

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.start_page.*
class StartPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_page)

        register.setOnClickListener(){
            val intent = Intent(this,Login2::class.java)
            startActivity(intent)
        }

        already_.setOnClickListener(){
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }

        already.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}