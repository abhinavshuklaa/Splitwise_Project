package com.example.splitwise.room_database_files

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.splitwise.R
import com.example.splitwise.Splitwise_HomeActivity
import kotlinx.android.synthetic.main.activity_choose__contact_.*
import kotlinx.android.synthetic.main.fragment_friends_.*

class Add_Friends_to_Database_Activity : AppCompatActivity(), View.OnClickListener {
    private lateinit var userViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose__contact_)
        initListeners()
        userViewModel = UserViewModelFactory(this).create(UserViewModel::class.java)


    }

    private fun initListeners() {
        btnAddThisFriend.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnAddThisFriend -> {
                if (isDataValid()) {
                    userViewModel.insertDataToDatabase(
                        name = etEnterNameOfTheFriend.text.toString(),
                        number = etEnteredPhoneNo.text.toString()
                    )
                }
                val intent=Intent(this@Add_Friends_to_Database_Activity,Splitwise_HomeActivity::class.java)
                startActivity(intent)

            }
        }

    }


    fun isDataValid(): Boolean {
        if (etEnterNameOfTheFriend.text.toString().isEmpty()) {
            etEnterNameOfTheFriend.error = "Name cannot be empty"
            return false
        }

        if (etEnteredPhoneNo.text.toString().isEmpty()) {
            etEnteredPhoneNo.error = "Number cannot be empty"
            return false
        }
        return true
    }
}

