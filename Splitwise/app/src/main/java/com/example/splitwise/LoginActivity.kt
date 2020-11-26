package com.example.splitwise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_log_in_and_sign_up.*
import kotlinx.android.synthetic.main.activity_log_in_and_sign_up.btnlogin
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initbuttons()
    }

    fun initbuttons() {
        btnSave.setOnClickListener(this)
        btnback.setOnClickListener(this)
        forgotpassword.setOnClickListener(this)
        auth = FirebaseAuth.getInstance()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnback -> {
                val intent = Intent(this@LoginActivity, LogInAndSignUpActivity::class.java)
                startActivity(intent)
            }
            R.id.btnSave -> {
                sugnUp()
            }
            R.id.forgotpassword -> {
                val intent = Intent(this@LoginActivity, ResetPasswordActivity::class.java)
                startActivity(intent)
            }
        }
    }
   private fun sugnUp(){
        if(email.text.toString().isEmpty()){
            email.error="Please enter email"
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
            email.error="Please enter valid email"
            return
        }
        if(password.text.toString().isEmpty()){
            password.error="Please enter Password"
            return
        } else {
            logIn(email.text.toString(),password.text.toString())
        }

    }
    private fun logIn(email:String,password:String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    intent=Intent(this@LoginActivity,ViewPagerIntroActivity::class.java)
                    startActivity(intent)
                    Log.d("Lakshmi", "signInWithEmail:success")
                    val user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Lakshmi", "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    // updateUI(null)
                    // ...
                    }
            }
    }




}