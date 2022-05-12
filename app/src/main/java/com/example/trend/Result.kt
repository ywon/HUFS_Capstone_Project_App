package com.example.trend

class Result {
    companion object{
        var id : String = ""
        var period : String = ""
        var result_1 : Int = 0
        var result_2 : Int = 0
        var result_3 : Int = 0
        var result_4 : Float = 0.0F
        var total_result : Int = 0

        fun setid(a : String){
            id = a
        }

        fun setperiod(a : String){
            period = a
        }

        fun setresult1( a : Int){
            result_1 = a
        }

        fun setresult2( a : Int){
            result_2 = a
        }

        fun setresult3( a : Int){
            result_3 = a
        }

        fun setresult4( a : Float){
            result_4 = a
        }

        fun settotalresult( a : Int){
            total_result = a
        }

        fun getid() : String{
            return id
        }

        fun getperiod() : String{
            return period
        }

        fun getresult1() : Int{
            return result_1
        }

        fun getresult2() : Int{
            return result_2
        }

        fun getresult3() : Int{
            return result_3
        }

        fun getresult4() : Float{
            return result_4
        }

        fun gettotalresult() : Int{
            return total_result
        }
    }
}