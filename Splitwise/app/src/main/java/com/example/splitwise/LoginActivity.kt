package com.example.splitwise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_log_in_and_sign_up.*
import kotlinx.android.synthetic.main.activity_log_in_and_sign_up.btnlogin
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initbuttons()
    }
    fun initbuttons(){
        btnSave.setOnClickListener(this)
        btnback.setOnClickListener(this)
        forgotpassword.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnback ->{
                val intent= Intent(this@LoginActivity,LogInAndSignUpActivity::class.java)
                startActivity(intent)
            }
            R.id.btnSave ->{
                val intent= Intent(this@LoginActivity,Splitwise_HomeActivity::class.java)
                startActivity(intent)
            }
            R.id.forgotpassword->{
                val intent= Intent(this@LoginActivity,ResetPasswordActivity::class.java)
                startActivity(intent)
            }
        }
    }
}