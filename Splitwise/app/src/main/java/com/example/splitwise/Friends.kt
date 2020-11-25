package com.example.splitwise

data class Friends(var friendId:String ,var transactionList: MutableList<Transactions> =mutableListOf<Transactions>() ){
    constructor():this(" ")

}