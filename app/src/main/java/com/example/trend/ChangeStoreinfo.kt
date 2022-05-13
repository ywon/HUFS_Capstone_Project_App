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
import kotlinx.android.synthetic.main.change_storeinfo.*
import kotlinx.android.synthetic.main.info_page.*
import org.json.JSONException
import org.json.JSONObject

class ChangeStoreinfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.change_storeinfo)

        val url: String = "http://211.226.15.97/storeInfoChange.php"

        btn_change.setOnClickListener(){
            infoVolley(this, url, Result.getid(), edit_storename.text.toString(), edit_category.text.toString(), edit_opendate.text.toString(), edit_sns.text.toString())
        }

    }
    private fun infoVolley(context: Context, url: String, userid : String, storename : String, category : String, opendate : String, sns : String ) {

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
                params["s1"] = storename
                params["s2"] = category
                params["s3"] = opendate
                params["s4"] = sns
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
                startActivity(Intent(this, StoreinfoPage::class.java))
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}