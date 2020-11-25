package com.example.splitwise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.splitwise.room_database_files.*
import kotlinx.android.synthetic.main.activity_add_icon.*

class AddIconActivity : AppCompatActivity(),View.OnClickListener ,RecyclerClickListener {
    private var userList = emptyList<User>()
    private lateinit var dropDownAdapter: DropDownAdapter
    private lateinit var userListViewModel: UserListViewModel

    private lateinit var transactionsViewModel: TransactionsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_icon)
        initListeners()
        userListViewModel = UserListViewModelFactory(this).create(UserListViewModel::class.java)
        transactionsViewModel=TransactionsViewModelFactory(this).create(TransactionsViewModel::class.java)

        userListViewModel.fetchDataFromDB().observe(this, {
            it?.let {
                this@AddIconActivity.userList = it
                dropDownAdapter.updateData(userList)
            }
        })
        setRecyclerAdapter()
        dropDownIconToGenerateSecondPerson.setOnClickListener {
            llEditLayout.visibility = View.VISIBLE
        }

    }

    private fun initListeners() {
        tvSaveToTransactionDatabase.setOnClickListener(this)
    }

    private fun setRecyclerAdapter() {
        dropDownAdapter = DropDownAdapter(userList, this)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerViewDropDownIcon.layoutManager = linearLayoutManager
        recyclerViewDropDownIcon.adapter = dropDownAdapter

    }

    override fun onItemCLicked(position: Int, user: User) {
        tvSecondPersonSpinner.text = user.name
        llEditLayout.visibility=View.GONE
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tvSaveToTransactionDatabase->{
                transactionsViewModel.insertToTransactionsDatabase("you",tvSecondPersonSpinner.text.toString(),etDescriptionOfTransaction.text.toString(),etAmountOfTransaction.text.toString())
            }
        }

    }
}