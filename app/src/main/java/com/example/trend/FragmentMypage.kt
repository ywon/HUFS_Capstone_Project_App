package com.example.trend

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentMypage :  Fragment(R.layout.mypage) {
    private lateinit var logout: Button
    private lateinit var info: Button

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
        info = view.findViewById(R.id.info)

        logout.setOnClickListener(){
            val intentStart = Intent(context, StartPage::class.java)
            startActivity(intentStart)
        }
        info.setOnClickListener(){
            val intentStart2 = Intent(context, InfoPage::class.java)
            startActivity(intentStart2)
        }
    }
}
