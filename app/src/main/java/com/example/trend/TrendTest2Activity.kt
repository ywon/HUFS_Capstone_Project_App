package com.example.trend

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.trend_test_2.*

class TrendTest2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trend_test_2)

        next_2.setOnClickListener(){
            val average : String = edit_average.text.toString()
            val initial : String = edit_initial.text.toString()
            val thisyear : Int = 2022
            val temp : Float = initial.toFloat()/average.toFloat()

            if(thisyear-Result.getperiod().toInt()>3){
                if(temp<0.02){
                    Result.setresult1(10)
                }
                if(temp>=0.02 && temp<0.03){
                    Result.setresult1(20)
                }
                if(temp>=0.03 && temp<0.04){
                    Result.setresult1(30)
                }
                if(temp>=0.04){
                    Result.setresult1(40)
                }
            }
            else{
                if(temp<0.02){
                    Result.setresult1(20)
                }
                if(temp>=0.02 && temp<0.03){
                    Result.setresult1(30)
                }
                if(temp>=0.03){
                    Result.setresult1(40)
                }
            }

            startActivity(Intent(this, TrendTest3Activity::class.java))
        }
    }
}