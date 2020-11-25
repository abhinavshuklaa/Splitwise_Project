package com.example.splitwise

data class Friends(

    val name:String,val userUID:String,val phoneNUmber:Long){
    constructor():this("","",-1)

}