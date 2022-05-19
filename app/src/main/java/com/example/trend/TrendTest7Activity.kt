package com.example.trend

import android.content.ContentValues
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.trend_test_7.*
import org.json.JSONException
import org.json.JSONObject
import kotlin.math.roundToInt

class TrendTest7Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trend_test_7)

        result.setText(Result.gettotalresult().toString())

        back_to_home.setOnClickListener(){
            var dialog = AlertDialog.Builder(this)

            dialog.setTitle("Notice")
            dialog.setMessage("\"마이페이지 > 점수 분석\"에서 더 많은 정보를 확인할 수 있어요!")

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