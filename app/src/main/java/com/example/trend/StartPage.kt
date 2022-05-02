package com.example.trend

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
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

    override fun onBackPressed() {
        var doubleBackToExit = false
        if (doubleBackToExit) {
            finishAffinity()
        } else {
            Toast.makeText(this, "종료하시려면 뒤로가기를 한번 더 눌러주세요.", Toast.LENGTH_SHORT).show()
            doubleBackToExit = true
            runDelayed(1500L) {
                doubleBackToExit = false
            }
        }
    }

    private fun runDelayed(millis: Long, function: () -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed(function, millis)
    }

}