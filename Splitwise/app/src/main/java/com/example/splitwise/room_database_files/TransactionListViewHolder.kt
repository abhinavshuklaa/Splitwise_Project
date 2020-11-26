package com.example.splitwise.room_database_files

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout_transaction_fragment.view.*

class TransactionListViewHolder(private val view:View):RecyclerView.ViewHolder(view) {

    fun setData(transactions: Transactions){
        view.apply {
            tvTransactionFirstPersonYou.text=transactions.firstPerson.toString()
            tvSecondPersonTransactionFragment.text=transactions.secondPerson
            var am=transactions.amount.toInt()/2
            tvAmountYouOweTransactionFragment.text="You Owe ${am}".toString()
        }
    }
}