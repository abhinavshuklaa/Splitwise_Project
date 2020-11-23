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
    private lateinit var mail: String
    private lateinit var pwd: String
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
            email.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
            email.error="Please enter valid email"
            email.requestFocus()
            return
        }
        if(password.text.toString().isEmpty()){
            password.error="Please enter Password"
            password.requestFocus()
            return
        }
       auth.createUserWithEmailAndPassword(email.text.toString(),password.text.toString()).
       addOnCompleteListener(this){task ->
           if(task.isSuccessful){
               val intent = Intent(this@LoginActivity, Splitwise_HomeActivity::class.java)
               startActivity(intent)
               finish()
           } else{
               Toast.makeText(this@LoginActivity,"Login Failed",Toast.LENGTH_SHORT).show()
               updateUI(null)
           }

       }
    }




    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser :FirebaseUser?= auth.currentUser
            updateUI(currentUser)

    }

    private fun updateUI(currentUser: FirebaseUser?) {


    }


    fun existingUser(mail: String, pwd: String) {
        auth.signInWithEmailAndPassword(mail, pwd)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Lakshmi", "signInWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
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

                // ...
            }
    }

    fun firebaseUser() {
        val user = Firebase.auth.currentUser
        user?.let {
            val name = user.displayName
            val email = user.email
            val photoUrl = user.photoUrl
            val emailVerified = user.isEmailVerified
            val uid = user.uid
        }
    }
}