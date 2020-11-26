package com.example.splitwise.room_database_files

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.splitwise.R

class TransactionListAdapter(private var transactionList: List<Transactions>) :
    RecyclerView.Adapter<TransactionListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionListViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_transaction_fragment, parent, false)
        return TransactionListViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionListViewHolder, position: Int) {
        val transactions = transactionList[position]
        holder.setData(transactions)
    }

    override fun getItemCount(): Int {
        return transactionList.size
    }

    fun updateData(transactionList: List<Transactions>) {
        this.transactionList = transactionList
        notifyDataSetChanged()

    }
}