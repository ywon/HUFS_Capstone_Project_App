package com.example.trend

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.info_page.*

class InfoPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_page)


        back.setOnClickListener(){
            //val intent = Intent(this, MainActivity::class.java)
            //startActivity(intent)
            startActivity(Intent(this, SmallBusiness::class.java))
            //startActivity(Intent(applicationContext, FragmentMypage::class.java))
        }
    }
}

        /*next_1.setOnClickListener(){
            Result.setperiod(edit_year.text.toString())
            var month: String = edit_month.text.toString()
            var day: String = edit_day.text.toString()
          */


