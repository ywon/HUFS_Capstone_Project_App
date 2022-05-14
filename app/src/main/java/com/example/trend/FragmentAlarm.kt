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

        trendVolley(requireContext(),url, Result.getid())
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
                Result.setresult1(jsonObject.getString("result_1").toInt())
                Result.setresult2(jsonObject.getString("result_2").toInt())
                Result.setresult3(jsonObject.getString("result_3").toInt())
                Result.setresult4(jsonObject.getString("result_4").toFloat())
                Result.settotalresult(jsonObject.getString("test_result").toInt())

                if(Result.gettotalresult()==0){ //총점 0인 경우
                    t1.setText("내 매장의 트렌드 분석 점수를 알아보세요!")
                    t2.setText("트렌드 분석 점수를 기반으로\n더 많은 정보를 얻을 수 있습니다.")
                    t3.setText("통상적으로 3년 안에 초기투자자본 \n\n비용만큼의 수익을 얻는다면,\n\n이는 성공한 사업으로 볼 수 있습니다.")
                }
                else{
                    t1.setText("내 매장의 새로운 트렌드 분석 점수는 \n\n몇 점일까요?")
                    t2.setText("통상적으로 3년 안에 초기투자자본 \n\n비용만큼의 수익을 얻는다면,\n\n이는 성공한 사업으로 볼 수 있습니다.")

                    if(Result.getresult3()==0){ //sns 점수 0인 경우
                        t4.setText("내 매장을 홍보할 수 있는 SNS를 개설해보세요!")
                    }
                    if(Result.getresult3()!=0){
                        t4.setText("SNS 친구들과 더 많이 소통해볼까요?")
                    }

                    if(Result.getresult2()==0){ //매출 하락
                        t3.setText("내 매장 매출이 하락중이군요.. \n\n노력 끝에는 반드시 성공이 있을거에요!")
                    }
                    if(Result.getresult2()==10){ //변화 없음
                        t3.setText("안정적인 매출 흐름이에요!\n\n조금만 더 힘을 내볼까요?")
                    }
                    if(Result.getresult2()==20){ //매출 상승
                        t3.setText("내 매장 매출은 상승중이에요!\n\n지금처럼만 쭉쭉 오르자구요!")
                    }
                }
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}