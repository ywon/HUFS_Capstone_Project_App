package com.example.trend

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.trend_test_5.*

class TrendTest5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trend_test_5)

        sns_one.setOnClickListener(){
            Result.setresult3(5)
            sns_one.setBackgroundColor(Color.parseColor("#FFF1DD95"))
            startActivity(Intent(this, TrendTest6Activity::class.java))
        }

        sns_two.setOnClickListener(){
            Result.setresult3(10)
            sns_two.setBackgroundColor(Color.parseColor("#FFF1DD95"))
            startActivity(Intent(this, TrendTest6Activity::class.java))
        }

        sns_three.setOnClickListener(){
            Result.setresult3(15)
            sns_three.setBackgroundColor(Color.parseColor("#FFF1DD95"))
            startActivity(Intent(this, TrendTest6Activity::class.java))
        }

        sns_four.setOnClickListener(){
            Result.setresult3(20)
            sns_four.setBackgroundColor(Color.parseColor("#FFF1DD95"))
            startActivity(Intent(this, TrendTest6Activity::class.java))
        }

    }
}