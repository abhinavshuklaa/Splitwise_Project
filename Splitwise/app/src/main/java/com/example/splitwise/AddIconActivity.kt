package com.example.splitwise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.splitwise.room_database_files.*
import kotlinx.android.synthetic.main.activity_add_icon.*

class AddIconActivity : AppCompatActivity(), View.OnClickListener, RecyclerClickListener {
    private var userList = emptyList<User>()
    private lateinit var dropDownAdapter: DropDownAdapter
    private lateinit var userListViewModel: UserListViewModel

    private lateinit var transactionsViewModel: TransactionsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_icon)
        initListeners()
        userListViewModel = UserListViewModelFactory(this).create(UserListViewModel::class.java)
        transactionsViewModel =
            TransactionsViewModelFactory(this).create(TransactionsViewModel::class.java)

        userListViewModel.fetchDataFromDB().observe(this, {
            it?.let {
                this@AddIconActivity.userList = it
                dropDownAdapter.updateData(userList)
            }
        })
        setRecyclerAdapter()
        setDescriptionIconImage()
        dropDownIconToGenerateSecondPerson.setOnClickListener {
            llEditLayout.visibility = View.VISIBLE
        }

    }

    private fun setDescriptionIconImage() {



    }

    private fun initListeners() {
        tvSaveToTransactionDatabase.setOnClickListener(this)
        etDescriptionOfTransaction.addTextChangedListener(edittextListener)
    }

    private fun setRecyclerAdapter() {
        dropDownAdapter = DropDownAdapter(userList, this)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerViewDropDownIcon.layoutManager = linearLayoutManager
        recyclerViewDropDownIcon.adapter = dropDownAdapter

    }

    override fun onItemCLicked(position: Int, user: User) {
        tvSecondPersonSpinner.text = user.name
        llEditLayout.visibility = View.GONE
    }

    private val edittextListener = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(message: Editable?) {
            when (message.toString().trim()) {

                "cab" -> {
                    Glide.with(ivChangeIconONTheBasisOfDescription)
                        .load("https://firebasestorage.googleapis.com/v0/b/splitwise-project.appspot.com/o/taxi.png?alt=media&token=8b592a2b-ea26-45d3-8ee4-590cb6698f4b")
                        .into(ivChangeIconONTheBasisOfDescription)
                }
//
                "food" -> {
                    Glide.with(ivChangeIconONTheBasisOfDescription)
                        .load("https://firebasestorage.googleapis.com/v0/b/splitwise-project.appspot.com/o/dish.png?alt=media&token=37f93914-943b-47c0-93ce-24110cab9e81")
                        .into(ivChangeIconONTheBasisOfDescription)
                }
                "medicine" -> {
                    Glide.with(ivChangeIconONTheBasisOfDescription)
                        .load("https://firebasestorage.googleapis.com/v0/b/splitwise-project.appspot.com/o/stethoscope.png?alt=media&token=90504304-e2eb-4b8b-9a9e-f90f4f781d22")
                        .into(ivChangeIconONTheBasisOfDescription)

                }
                else -> {
                    Glide.with(ivChangeIconONTheBasisOfDescription)
                        .load("https://firebasestorage.googleapis.com/v0/b/splitwise-project.appspot.com/o/writing.png?alt=media&token=71197e39-92d0-4b8b-9028-a44f38af57ca")
                        .into(ivChangeIconONTheBasisOfDescription)
                }
            }
        }

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.tvSaveToTransactionDatabase -> {
                transactionsViewModel.insertToTransactionsDatabase(
                    "you",
                    tvSecondPersonSpinner.text.toString(),
                    etDescriptionOfTransaction.text.toString(),
                    etAmountOfTransaction.text.toString()
                )
            }
        }

    }
}