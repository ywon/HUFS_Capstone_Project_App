package com.example.trend

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.trend_result_info.*
import org.json.JSONException
import org.json.JSONObject

class FragmentAlarm : Fragment(R.layout.alarm) {
    private lateinit var t1 : TextView
    private lateinit var t2 : TextView
    private lateinit var t3 : TextView
    private lateinit var t4 : TextView

    val url: String = "http://211.226.15.97/trendresultInfo.php"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.alarm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        t1 = view.findViewById(R.id.t1)
        t2 = view.findViewById(R.id.t2)
        t3 = view.findViewById(R.id.t3)
        t4 = view.findViewById(R.id.t4)

        //trendVolley(requireContext(),url, Result.getid())
    }

    private fun trendVolley(context: Context, url: String, userid : String ) {

        // 1. RequestQueue 생성 및 초기화
        val requestQueue = Volley.newRequestQueue(context)

        // 2. Request Object인 StringRequest 생성
        val request: StringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener { response ->
                showJSONList(response, userid)
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

    private fun showJSONList(response: String, userid : String) {
        try {
            Log.e("TAG",response)
            val jsonObject = JSONObject(response)
            if(jsonObject.getString("success")=="true") {
                if(jsonObject.getString("trend_result").equals("0")==true){
                    t1.setText("트렌드 분석 점수 테스트를 통해\n내 매장의 트렌드 분석 점수를 알아보세요!")
                }
                if(jsonObject.getString("trend_result").equals("0")==false){
                    t1.setText("내 매장의 최신 트렌드 분석 점수를 알아보세요!")
                }
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}