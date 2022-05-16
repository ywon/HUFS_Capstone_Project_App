package com.example.trend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.setting_page.*

class SettingPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting_page)

        /*back.setOnClickListener(){
            startActivity(Intent(this, MainActivity::class.java))
        }*/
    }
}