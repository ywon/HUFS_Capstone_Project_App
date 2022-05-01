package com.example.trend

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.trend_test_6.*

class TrendTest6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trend_test_6)

        next_5.setOnClickListener(){
            val review : String = edit_review.text.toString()
            Result.setresult4(review.toFloat() * 4)
            startActivity(Intent(this, TrendTest7Activity::class.java))
        }
    }
}