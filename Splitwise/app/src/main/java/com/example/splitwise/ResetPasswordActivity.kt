package com.example.splitwise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_reset_password.*

class ResetPasswordActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        auth = FirebaseAuth.getInstance()
        btnreset.setOnClickListener(this)
    }
    fun resetpassword(email:String){
        auth.sendPasswordResetEmail(email).addOnCompleteListener(this){task->
            if(task.isSuccessful){
                Toast.makeText(this@ResetPasswordActivity, "Check email to reset your password!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this@ResetPasswordActivity, "Fail to send reset password email!", Toast.LENGTH_SHORT).show();
            }


        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnreset -> {
                resetpassword(etEmailAddress.text.toString());
            }
            R.id.btnback ->{
                val intent= Intent(this@ResetPasswordActivity,LogInAndSignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }

}