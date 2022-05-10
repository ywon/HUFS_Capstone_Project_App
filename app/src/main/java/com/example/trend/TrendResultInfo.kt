package com.example.trend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.trend_result_info.*

class TrendResultInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trend_result_info)

        back.setOnClickListener(){
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}