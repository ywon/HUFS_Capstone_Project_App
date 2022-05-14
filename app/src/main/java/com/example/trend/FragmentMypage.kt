package com.example.trend

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.mypage.*
import kotlinx.android.synthetic.main.trend_result_info.*
import org.json.JSONException
import org.json.JSONObject

class FragmentMypage :  Fragment(R.layout.mypage) {
    private lateinit var logout : Button
    private lateinit var trend_result_info : Button
    private lateinit var info : Button
    private lateinit var storeinfo : Button
    private lateinit var notice : Button
    private lateinit var setting : Button
    private lateinit var trend_result : TextView
    private lateinit var username : TextView
    private lateinit var email_mypage : TextView

    val url: String = "http://211.226.15.97/trendresultTotal.php";

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.mypage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        logout = view.findViewById(R.id.logout)
        trend_result_info = view.findViewById(R.id.trend_result_info)
        info = view.findViewById(R.id.info)
        storeinfo = view.findViewById(R.id.storeinfo)
        notice = view.findViewById(R.id.noticeButton)
        setting = view.findViewById(R.id.settingButton)
        trend_result = view.findViewById(R.id.trend_result)
        username = view.findViewById(R.id.username)
        email_mypage = view.findViewById(R.id.email_mypage)

        trendVolley(requireContext(), url, Result.getid(), Result.gettotalresult())

        logout.setOnClickListener(){
            val intentStart = Intent(context, StartPage::class.java)
            startActivity(intentStart)
        }

        trend_result_info.setOnClickListener(){
            startActivity(Intent(context, TrendResultInfo::class.java))
        }

        info.setOnClickListener(){
            val intentStart2 = Intent(context, InfoPage::class.java)
            startActivity(intentStart2)
        }

        storeinfo.setOnClickListener(){
            val intentStart3 = Intent(context, StoreinfoPage::class.java)
            startActivity(intentStart3)
        }

        notice.setOnClickListener(){
            val intentStart4 = Intent(context, NoticePage::class.java)
            startActivity(intentStart4)
        }

        setting.setOnClickListener(){
            val intentStart3 = Intent(context, SettingPage::class.java)
            startActivity(intentStart3)
        }
    }

    private fun trendVolley(context: Context, url: String, userid: String, total_result:Int ) {

        // 1. RequestQueue 생성 및 초기화
        val requestQueue = Volley.newRequestQueue(context)

        // 2. Request Object인 StringRequest 생성
        val request: StringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener { response ->
                showJSONList(response, userid, total_result)
            },
            Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }
        ) {
            override fun getParams(): Map<String, String> {
                val params: MutableMap<String,String> = HashMap()
                params["userid"] = userid
                params["tr"] = total_result.toString()
                return params
            }
        }
        requestQueue.add(request)
    }

    private fun showJSONList(response: String, userid : String, total_result :Int) {
        try {
            Log.e("TAG",response)
            val jsonObject = JSONObject(response)
            if(jsonObject.getString("success")=="true") {
                trend_result.setText(jsonObject.getString("test_result"))
                email_mypage.setText(jsonObject.getString("email"))
                username.setText(jsonObject.getString("id"))
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }


}