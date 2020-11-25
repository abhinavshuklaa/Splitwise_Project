package com.example.splitwise

data class Transactions(var timestamp :String,var amount:String,var adder:String,var addedWith:List<String>,
var transactionType:Int) {
    constructor():this("","","", emptyList(),-1)
}