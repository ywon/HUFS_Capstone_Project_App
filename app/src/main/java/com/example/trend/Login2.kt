package com.example.trend

import android.content.ContentValues
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class Login2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        val register_check : Button = findViewById<Button>(R.id.btn_register_check)
        val id : EditText = findViewById<EditText>(R.id.edit_id)
        val pw : EditText = findViewById<EditText>(R.id.edit_pw)
        val pw_check : EditText = findViewById<EditText>(R.id.edit_pw_check)
        val business_num : EditText = findViewById<EditText>(R.id.edit_business_num)

        val url: String = "http://10.0.2.2:8080/register.php";

        register_check.setOnClickListener(){
            var userID: String = id.text.toString()
            var userPW: String = pw.text.toString()
            var bs : String = business_num.text.toString()
            var pwcheck : String = pw_check.text.toString()
            if(userPW==pwcheck){
                registerVolley(this, url, userID, userPW, bs)
            }
            else{
                dialog("fail")
            }
        }

    }

    private fun registerVolley(context: Context, url: String, userid: String, password: String, business : String) {

        // 1. RequestQueue 생성 및 초기화
        val requestQueue = Volley.newRequestQueue(context)

        // 2. Request Object인 StringRequest 생성
        val request: StringRequest = object : StringRequest(
            Method.POST, url,
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
                params["business"] = business
                return params
            }
        }
        requestQueue.add(request)
    }

    private fun showJSONList(response: String, userid: String, password: String) {
        try {
            Log.e("TAG",response)
            val jsonObject = JSONObject(response)
            if(jsonObject.getString("success")=="true") {
                dialog("success")
                startActivity(Intent(this, Login::class.java))
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun dialog(type: String) {
        var dialog = AlertDialog.Builder(this)

        if (type.equals("success")) {
            dialog.setTitle("회원가입 성공")
            dialog.setMessage("환영합니다!")
        } else if (type.equals("fail")) {
            dialog.setTitle("비밀번호 확인")
            dialog.setMessage("비밀번호가 다릅니다.")
        }

        var dialog_listener = object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                when (which) {
                    DialogInterface.BUTTON_POSITIVE ->
                        Log.d(ContentValues.TAG, "")
                }
            }
        }

        dialog.setPositiveButton("확인", dialog_listener)
        dialog.show()
    }
}