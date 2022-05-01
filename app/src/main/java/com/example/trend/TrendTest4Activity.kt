package com.example.trend

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.trend_test_4.*

class TrendTest4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trend_test_4)

        yes.setOnClickListener(){
            yes.setBackgroundColor(Color.parseColor("#FFF1DD95"))
            startActivity(Intent(this, TrendTest5Activity::class.java))
        }

        no.setOnClickListener(){
            Result.setresult3(0)
            no.setBackgroundColor(Color.parseColor("#FFF1DD95"))
            startActivity(Intent(this, TrendTest6Activity::class.java))
        }
    }
}