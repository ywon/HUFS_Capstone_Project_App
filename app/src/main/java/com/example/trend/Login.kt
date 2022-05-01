package com.example.trend

import android.content.ContentValues.TAG
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONException
import org.json.JSONObject


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val id : EditText = findViewById<EditText>(R.id.edit_id)
        val pw : EditText = findViewById<EditText>(R.id.edit_pw)
        val url: String = "http://10.0.2.2:8080/loginn.php";

        btn_register.setOnClickListener(){
            val intent = Intent(this,Login2::class.java)
            startActivity(intent)
        }

        btn_login.setOnClickListener(){
            var userID: String = id.text.toString()
            var userPW: String = pw.text.toString()
            loginVolley(this, url, userID, userPW)
        }
    }
    private fun loginVolley(context: Context, url: String, userid: String, password: String) {

        // 1. RequestQueue 생성 및 초기화
        val requestQueue = Volley.newRequestQueue(context)

        // 2. Request Object인 StringRequest 생성
        val request: StringRequest = object : StringRequest(Method.POST, url,
            Response.Listener { response ->
                showJSONList(response, userid, password)
            },
            Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }
        ) {
            override fun getParams(): Map<String, String> {
                val params: MutableMap<String,String> = HashMap()
                params["userid"] = userid
                params["password"] = password
                return params
            }
        }
        requestQueue.add(request)
    }

    private fun showJSONList(response: String, userid: String, password: String) {
        try {
            Log.e("TAG",response)
            val jsonObject = JSONObject(response)
            if(jsonObject.getString("id").toString() == userid && jsonObject.getString("pw").toString() == password) {
                dialog("success")
                startActivity(Intent(this, MainActivity::class.java))
            }

            else {
                dialog("fail")
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun dialog(type: String){
        var dialog = AlertDialog.Builder(this)

        if(type.equals("success")){
            dialog.setTitle("로그인 성공")
            dialog.setMessage("로그인 성공!")
        }
        else if(type.equals("fail")){
            dialog.setTitle("로그인 실패")
            dialog.setMessage("아이디와 비밀번호를 확인해주세요")
        }

        var dialog_listener = object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                when(which){
                    DialogInterface.BUTTON_POSITIVE ->
                        Log.d(TAG, "")
                }
            }
        }

        dialog.setPositiveButton("확인",dialog_listener)
        dialog.show()
    }
}