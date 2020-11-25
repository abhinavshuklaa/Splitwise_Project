package com.example.splitwise


data class Database(  var userId: String,  var email :String ,  var phoneNo:String,
                      var name:String ,
                      var imageUrl:String="Default"
//                      ,var friendList :MutableList<Friends> = mutableListOf()
)
{
    constructor():this("","","","")

}