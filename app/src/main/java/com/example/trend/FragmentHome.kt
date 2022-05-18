package com.example.trend

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
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
import kotlinx.android.synthetic.main.home.*
import org.json.JSONException
import org.json.JSONObject

class FragmentHome : Fragment(R.layout.home) {
    private lateinit var select : TextView

    private lateinit var num1 : TextView
    private lateinit var num2 : TextView
    private lateinit var num3 : TextView

    private lateinit var top1 : TextView
    private lateinit var top2 : TextView
    private lateinit var top3 : TextView
    private lateinit var top4 : TextView
    private lateinit var top5 : TextView
    private lateinit var top6 : TextView
    private lateinit var top7 : TextView
    private lateinit var top8 : TextView
    private lateinit var top9 : TextView
    private lateinit var top10 : TextView

    private lateinit var category : Button

    val url: String = "http://211.226.15.97/successStore.php"
    val urlcafe: String = "http://211.226.15.97/cafe.php"
    val urlfood: String = "http://211.226.15.97/restaurant.php"
    val urlplace: String = "http://211.226.15.97/place.php"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        select = view.findViewById(R.id.category_select)

        num1 = view.findViewById(R.id.num1)
        num2 = view.findViewById(R.id.num2)
        num3 = view.findViewById(R.id.num3)

        top1 = view.findViewById(R.id.top1)
        top2 = view.findViewById(R.id.top2)
        top3 = view.findViewById(R.id.top3)
        top4 = view.findViewById(R.id.top4)
        top5 = view.findViewById(R.id.top5)
        top6 = view.findViewById(R.id.top6)
        top7 = view.findViewById(R.id.top7)
        top8 = view.findViewById(R.id.top8)
        top9 = view.findViewById(R.id.top9)
        top10 = view.findViewById(R.id.top10)

        category = view.findViewById(R.id.category)

        trendVolley(requireContext(),url)
        trendVolleyCafe(requireContext(),urlcafe)
        category_select.setText("카페")

        category.setOnClickListener(){
            val items = arrayOf("카페", "음식점", "핫플레이스")
            var selectedItem: String? = null
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("관심 카테고리 선택")
            builder.setSingleChoiceItems(items, -1){ dialog, which ->
                selectedItem = items[which]
            }
            builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->
                if (selectedItem == "카페") {
                    category_select.setText("카페")
                    trendVolleyCafe(requireContext(), urlcafe)
                }
                if (selectedItem == "음식점") {
                    category_select.setText("음식점")
                    trendVolleyRestaurant(requireContext(), urlfood)
                }
                if (selectedItem == "핫플레이스") {
                    category_select.setText("핫플레이스")
                    trendVolleyPlace(requireContext(), urlplace)
                }
                Toast.makeText(requireContext(),"확인", Toast.LENGTH_LONG)
            }

            builder.show()
        }
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

    private fun trendVolleyCafe(context: Context, url: String) {

        // 1. RequestQueue 생성 및 초기화
        val requestQueue = Volley.newRequestQueue(context)

        // 2. Request Object인 StringRequest 생성
        val request: StringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener { response ->
                showJSONListCafe(response)
            },
            Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }
        ){
        }
        requestQueue.add(request)
    }

    private fun showJSONListCafe(response: String) {
        try {
            Log.e("TAG",response)
            val jsonObject = JSONObject(response)
            if(jsonObject.getString("success")=="true") {
                top1.setText(jsonObject.getString("c1"))
                top2.setText(jsonObject.getString("c2"))
                top3.setText(jsonObject.getString("c3"))
                top4.setText(jsonObject.getString("c4"))
                top5.setText(jsonObject.getString("c5"))
                top6.setText(jsonObject.getString("c6"))
                top7.setText(jsonObject.getString("c7"))
                top8.setText(jsonObject.getString("c8"))
                top9.setText(jsonObject.getString("c9"))
                top10.setText(jsonObject.getString("c10"))
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun trendVolleyRestaurant(context: Context, url: String) {

        // 1. RequestQueue 생성 및 초기화
        val requestQueue = Volley.newRequestQueue(context)

        // 2. Request Object인 StringRequest 생성
        val request: StringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener { response ->
                showJSONListRestaurant(response)
            },
            Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }
        ){
        }
        requestQueue.add(request)
    }

    private fun showJSONListRestaurant(response: String) {
        try {
            Log.e("TAG",response)
            val jsonObject = JSONObject(response)
            if(jsonObject.getString("success")=="true") {
                top1.setText(jsonObject.getString("c1"))
                top2.setText(jsonObject.getString("c2"))
                top3.setText(jsonObject.getString("c3"))
                top4.setText(jsonObject.getString("c4"))
                top5.setText(jsonObject.getString("c5"))
                top6.setText(jsonObject.getString("c6"))
                top7.setText(jsonObject.getString("c7"))
                top8.setText(jsonObject.getString("c8"))
                top9.setText(jsonObject.getString("c9"))
                top10.setText(jsonObject.getString("c10"))
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun trendVolleyPlace(context: Context, url: String) {

        // 1. RequestQueue 생성 및 초기화
        val requestQueue = Volley.newRequestQueue(context)

        // 2. Request Object인 StringRequest 생성
        val request: StringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener { response ->
                showJSONListPlace(response)
            },
            Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }
        ){
        }
        requestQueue.add(request)
    }

    private fun showJSONListPlace(response: String) {
        try {
            Log.e("TAG",response)
            val jsonObject = JSONObject(response)
            if(jsonObject.getString("success")=="true") {
                top1.setText(jsonObject.getString("c1"))
                top2.setText(jsonObject.getString("c2"))
                top3.setText(jsonObject.getString("c3"))
                top4.setText(jsonObject.getString("c4"))
                top5.setText(jsonObject.getString("c5"))
                top6.setText(jsonObject.getString("c6"))
                top7.setText(jsonObject.getString("c7"))
                top8.setText(jsonObject.getString("c8"))
                top9.setText(jsonObject.getString("c9"))
                top10.setText(jsonObject.getString("c10"))
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}