package com.example.splitwise


data class Database(  var userId: String,  var email :String ,  var phoneNo:String,
                      var name:String ,
                      val imageUrl:String
)
{
    constructor():this("","","","","" )

}