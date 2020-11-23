package com.example.splitwise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btnSave
import kotlinx.android.synthetic.main.activity_login.btnback
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initbuttons()
    }
    fun initbuttons(){
        btnSave.setOnClickListener(this)
        btnback.setOnClickListener(this)
        byusingsignup.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnback ->{
                val intent= Intent(this@SignUpActivity,LogInAndSignUpActivity::class.java)
                startActivity(intent)
            }
            R.id.btnSave ->{
                val intent= Intent(this@SignUpActivity,Splitwise_HomeActivity::class.java)
                startActivity(intent)
            }
            R.id.btnsignup ->{
                val intent= Intent(this@SignUpActivity,TermaOfService::class.java)
                startActivity(intent)
            }

        }
    }
}