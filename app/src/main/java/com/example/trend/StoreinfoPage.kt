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
import kotlinx.android.synthetic.main.storeinfo_page.*
import org.json.JSONException
import org.json.JSONObject

class StoreinfoPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.storeinfo_page)

        val url: String = "http://10.0.2.2:8080/storeInfo.php"

        //주석처리
        //infoVolley(this, url, Result.getid())

        back.setOnClickListener(){
            startActivity(Intent(this, MainActivity::class.java))
        }

        change.setOnClickListener(){
            startActivity(Intent(this, ChangeStoreinfo::class.java))
        }
    }

    private fun infoVolley(context: Context, url: String, userid : String) {

        // 1. RequestQueue 생성 및 초기화
        val requestQueue = Volley.newRequestQueue(context)

        // 2. Request Object인 StringRequest 생성
        val request: StringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener { response ->
                showJSONList(response)
            },
            Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }
        ) {
            override fun getParams(): Map<String, String> {
                val params: MutableMap<String,String> = HashMap()
                params["userid"] = userid
                return params
            }
        }
        requestQueue.add(request)
    }

    private fun showJSONList(response: String) {
        try {
            Log.e("TAG",response)
            val jsonObject = JSONObject(response)
            if(jsonObject.getString("success")=="true") {
                storename.setText(jsonObject.getString("store_name"))
                category.setText(jsonObject.getString("category"))
                opendate.setText(jsonObject.getString("open_date"))
                sns.setText((jsonObject.getString("sns")))
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}