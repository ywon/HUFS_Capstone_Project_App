package com.example.trend

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class FragmentCommunity : Fragment(R.layout.community) {
    private lateinit var start :Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.community, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        start = view.findViewById(R.id.test_start)
        start.setOnClickListener(){
            val intentStart = Intent(context, TrendTest1Activity::class.java)
            startActivity(intentStart)
        }
    }
}