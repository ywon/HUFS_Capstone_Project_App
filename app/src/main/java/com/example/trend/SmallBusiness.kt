package com.example.trend

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_small_business1.*

class SmallBusiness : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_small_business1)

        first.setOnClickListener(){
            val intent1 = Intent(Intent.ACTION_VIEW, Uri.parse("https://ols.sbiz.or.kr/"))
            startActivity(intent1)
        }

        second.setOnClickListener(){
            val intent2 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.semas.or.kr/web/board/webBoardView.kmdc?bCd=1&schCat=&rlIdx=&schCon=&schStr=&page=2&b_idx=35076&pNm=BOA0101&eventMode="))
            startActivity(intent2)
        }

        third.setOnClickListener(){
            val intent3 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.semas.or.kr/web/board/webBoardView.kmdc?bCd=1&schCat=&rlIdx=&schCon=&schStr=&page=2&b_idx=35074&pNm=BOA0101&eventMode="))
            startActivity(intent3)
        }

        fourth.setOnClickListener(){
            val intent4 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.semas.or.kr/web/board/webBoardView.kmdc?bCd=1&schCat=&rlIdx=&schCon=&schStr=&page=2&b_idx=35075&pNm=BOA0101&eventMode="))
            startActivity(intent4)
        }

        fifth.setOnClickListener(){
            val intent5 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.semas.or.kr/web/board/webBoardView.kmdc?bCd=1&schCat=&rlIdx=&schCon=&schStr=&page=2&b_idx=35078&pNm=BOA0101&eventMode="))
            startActivity(intent5)
        }

        sixth.setOnClickListener(){
            val intent6 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.semas.or.kr/web/board/webBoardView.kmdc?bCd=1&schCat=&rlIdx=&schCon=&schStr=&page=1&b_idx=35079&pNm=BOA0101&eventMode="))
            startActivity(intent6)
        }

        seventh.setOnClickListener(){
            val intent7 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.semas.or.kr/web/board/webBoardView.kmdc?bCd=1&schCat=&rlIdx=&schCon=&schStr=&page=2&b_idx=35073&pNm=BOA0101&eventMode="))
            startActivity(intent7)
        }

        eighth.setOnClickListener(){
            val intent8 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.semas.or.kr/web/board/webBoardView.kmdc?bCd=902&schCat=&rlIdx=&schCon=&schStr=&page=1&b_idx=34707&pNm=BOA01018&eventMode="))
            startActivity(intent8)
        }

        ninth.setOnClickListener(){
            val intent9 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.semas.or.kr/web/board/webBoardView.kmdc?bCd=1&schCat=&rlIdx=&schCon=&schStr=&page=2&b_idx=35077&pNm=BOA0101&eventMode="))
            startActivity(intent9)
        }
    }
}