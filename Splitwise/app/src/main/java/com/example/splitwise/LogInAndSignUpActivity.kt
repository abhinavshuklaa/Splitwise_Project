package com.example.splitwise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_log_in_and_sign_up.*

class LogInAndSignUpActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_and_sign_up)
        initbuttons()
    }
    fun initbuttons(){
        btnlogin.setOnClickListener(this)
        btnsignup.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
          R.id.btnlogin ->{
             val intent=Intent(this@LogInAndSignUpActivity,LoginActivity::class.java)
              startActivity(intent)
          }
            R.id.btnsignup ->{
                val intent=Intent(this@LogInAndSignUpActivity,SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }
}