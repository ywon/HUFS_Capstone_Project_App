package com.example.trend

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.trend_test_1.*

class TrendTest1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trend_test_1)

        next_1.setOnClickListener(){
            Result.setperiod(edit_year.text.toString())
            var month: String = edit_month.text.toString()
            var day: String = edit_day.text.toString()
            startActivity(Intent(this, TrendTest2Activity::class.java))
        }
    }
}