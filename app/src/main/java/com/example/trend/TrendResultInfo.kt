package com.example.trend

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.mypage.*
import kotlinx.android.synthetic.main.trend_result_info.*
import org.json.JSONException
import org.json.JSONObject

class TrendResultInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trend_result_info)

        val url: String = "http://211.226.15.97/trendresultInfo.php"

        trendVolley(this, url, Result.getid(), Result.getresult1(), Result.getresult2(), Result.getresult3(), Result.getresult4().toInt(), Result.gettotalresult())
        /*back.setOnClickListener(){
            startActivity(Intent(this, MainActivity::class.java))
        }*/
    }
    private fun trendVolley(context: Context, url: String, userid : String, result_1 :Int, result_2 :Int, result_3 :Int, result_4 :Int, total_result :Int ) {

        // 1. RequestQueue 생성 및 초기화
        val requestQueue = Volley.newRequestQueue(context)

        // 2. Request Object인 StringRequest 생성
        val request: StringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener { response ->
                showJSONList(response, userid, result_1, result_2, result_3, result_4, total_result)
            },
            Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }
        ) {
            override fun getParams(): Map<String, String> {
                val params: MutableMap<String,String> = HashMap()
                params["userid"] = userid
                params["r1"] = result_1.toString()
                params["r2"] = result_2.toString()
                params["r3"] = result_3.toString()
                params["r4"] = result_4.toString()
                params["tr"] = total_result.toString()
                return params
            }
        }
        requestQueue.add(request)
    }

    private fun showJSONList(response: String, userid : String, result_1 :Int,result_2 :Int,result_3 :Int,result_4 :Int, total_result :Int) {
        try {
            Log.e("TAG",response)
            val jsonObject = JSONObject(response)
            if(jsonObject.getString("success")=="true") {
                r1.setProgress(jsonObject.getString("result_1").toInt())
                r2.setProgress(jsonObject.getString("result_2").toInt())
                r3.setProgress(jsonObject.getString("result_3").toInt())
                r4.setProgress(jsonObject.getString("result_4").toInt())
                result.setText(jsonObject.getString("test_result"))

            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}