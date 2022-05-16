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
import org.json.JSONException
import org.json.JSONObject

class FragmentHome : Fragment(R.layout.home) {
    private lateinit var num1 : TextView
    private lateinit var num2 : TextView
    private lateinit var num3 : TextView

    val url: String = "http://211.226.15.97/successStore.php"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        num1 = view.findViewById(R.id.num1)
        num2 = view.findViewById(R.id.num2)
        num3 = view.findViewById(R.id.num3)

        trendVolley(requireContext(),url)
    }

    private fun trendVolley(context: Context, url: String) {

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
        ){
        }
        requestQueue.add(request)
    }

    private fun showJSONList(response: String) {
        try {
            Log.e("TAG",response)
            val jsonObject = JSONObject(response)
            if(jsonObject.getString("success")=="true") {
                num1.setText(jsonObject.getString("store_name1"))
                num2.setText(jsonObject.getString("store_name2"))
                num3.setText(jsonObject.getString("store_name3"))
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}