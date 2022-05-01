package com.example.trend

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class FragmentSupport : Fragment() {
    private lateinit var btnfirst: Button
    private lateinit var btnsecond: Button
    private lateinit var btnthird: Button
    private lateinit var btnfourth: Button
    private lateinit var btnfifth: Button
    private lateinit var btnsixth: Button
    private lateinit var btnseventh: Button
    private lateinit var btneighth: Button
    private lateinit var btnninth: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.support, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnfirst = view.findViewById(R.id.first)
        btnsecond = view.findViewById(R.id.second)
        btnthird = view.findViewById(R.id.third)
        btnfourth = view.findViewById(R.id.fourth)
        btnfifth = view.findViewById(R.id.fifth)
        btnsixth = view.findViewById(R.id.sixth)
        btnseventh = view.findViewById(R.id.seventh)
        btneighth = view.findViewById(R.id.eighth)
        btnninth = view.findViewById(R.id.ninth)

        btnfirst.setOnClickListener(){
            val intent1 = Intent(Intent.ACTION_VIEW, Uri.parse("https://ols.sbiz.or.kr/"))
            startActivity(intent1)
        }
        btnsecond.setOnClickListener(){
            val intent2 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.semas.or.kr/web/board/webBoardView.kmdc?bCd=1&schCat=&rlIdx=&schCon=&schStr=&page=2&b_idx=35076&pNm=BOA0101&eventMode="))
            startActivity(intent2)
        }

        btnthird.setOnClickListener(){
            val intent3 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.semas.or.kr/web/board/webBoardView.kmdc?bCd=1&schCat=&rlIdx=&schCon=&schStr=&page=2&b_idx=35074&pNm=BOA0101&eventMode="))
            startActivity(intent3)
        }

        btnfourth.setOnClickListener(){
            val intent4 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.semas.or.kr/web/board/webBoardView.kmdc?bCd=1&schCat=&rlIdx=&schCon=&schStr=&page=2&b_idx=35075&pNm=BOA0101&eventMode="))
            startActivity(intent4)
        }

        btnfifth.setOnClickListener(){
            val intent5 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.semas.or.kr/web/board/webBoardView.kmdc?bCd=1&schCat=&rlIdx=&schCon=&schStr=&page=2&b_idx=35078&pNm=BOA0101&eventMode="))
            startActivity(intent5)
        }

        btnsixth.setOnClickListener(){
            val intent6 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.semas.or.kr/web/board/webBoardView.kmdc?bCd=1&schCat=&rlIdx=&schCon=&schStr=&page=1&b_idx=35079&pNm=BOA0101&eventMode="))
            startActivity(intent6)
        }

        btnseventh.setOnClickListener(){
            val intent7 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.semas.or.kr/web/board/webBoardView.kmdc?bCd=1&schCat=&rlIdx=&schCon=&schStr=&page=2&b_idx=35073&pNm=BOA0101&eventMode="))
            startActivity(intent7)
        }

        btneighth.setOnClickListener(){
            val intent8 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.semas.or.kr/web/board/webBoardView.kmdc?bCd=902&schCat=&rlIdx=&schCon=&schStr=&page=1&b_idx=34707&pNm=BOA01018&eventMode="))
            startActivity(intent8)
        }

        btnninth.setOnClickListener(){
            val intent9 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.semas.or.kr/web/board/webBoardView.kmdc?bCd=1&schCat=&rlIdx=&schCon=&schStr=&page=2&b_idx=35077&pNm=BOA0101&eventMode="))
            startActivity(intent9)
        }
    }
}