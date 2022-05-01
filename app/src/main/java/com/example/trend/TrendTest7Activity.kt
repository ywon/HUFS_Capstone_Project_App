package com.example.trend

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.trend_test_7.*
import kotlin.math.roundToInt

class TrendTest7Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trend_test_7)

        val num : Float = (Result.getresult1() + Result.getresult2() + Result.getresult3() + Result.getresult4()).roundToInt() / 1f
        val numint = num.toInt()
        result.setText(numint.toString())

        back_to_home.setOnClickListener(){
            var dialog = AlertDialog.Builder(this)

            dialog.setTitle("Notice")
            dialog.setMessage("My Page에서 더 많은 정보를 \n 확인할 수 있어요!")

            var dialog_listener = object: DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    when(which){
                        DialogInterface.BUTTON_POSITIVE ->
                            startActivity(Intent(applicationContext, MainActivity::class.java))

                    }
                }
            }
            dialog.setPositiveButton("확인",dialog_listener)
            dialog.show()
        }
    }

}