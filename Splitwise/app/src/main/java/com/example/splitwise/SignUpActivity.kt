package com.example.splitwise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.NonNull
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btnSave
import kotlinx.android.synthetic.main.activity_login.btnback
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.lang.ref.PhantomReference

class SignUpActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var firebaseAuth:FirebaseAuth
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initbuttons()
    }
    fun initbuttons(){
        btnSave.setOnClickListener(this)
        btnback.setOnClickListener(this)
        byusingsignup.setOnClickListener(this)
        firebaseAuth= FirebaseAuth.getInstance()
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnback ->{
                val intent= Intent(this@SignUpActivity,LogInAndSignUpActivity::class.java)
                startActivity(intent)
            }
            R.id.btnSave ->{
                sugnUp()
            }
            R.id.btnsignup ->{
                val intent= Intent(this@SignUpActivity,SignUpActivity::class.java)
                startActivity(intent)
            }

        }
    }
    private fun sugnUp() {
        if (mail.text.toString().isEmpty()) {
            mail.error = "Please enter email"
            mail.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(mail.text.toString()).matches()) {
            mail.error = "Please enter valid email"
            mail.requestFocus()
            return
        }
        if (pwd.text.toString().isEmpty()) {
            pwd.error = "Please enter Password"
            pwd.requestFocus()
            return
        }
        if(etFullname.text.toString().isEmpty()){
            etFullname.error="Plear Enter name"
            etFullname.requestFocus()
            return
        } else {
            register(etFullname.text.toString(),mail.text.toString(),pwd.text.toString())
        }
    }
    private fun register(musername:String,mmail:String,mpwd:String) {
        firebaseAuth.signInWithEmailAndPassword(mmail, mpwd)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("Lakshmi", "signInWithEmail:success")
                    val user = firebaseAuth.currentUser
                    val userId:String?=user?.uid
                    databaseReference=FirebaseDatabase.getInstance().getReference("Users").child(userId!!)
                    var hashmap:HashMap<String,String> = HashMap()
                    hashmap.put("userId",userId!!)
                    hashmap.put("email",mmail)
                    hashmap.put("mpwd",mpwd)
                    hashmap.put("musername",musername)
                    hashmap.put("imageurl","default")
                    databaseReference.setValue(hashmap).addOnCompleteListener(this){task ->

                        if(task.isSuccessful){
                            val intent= Intent(this@SignUpActivity,LoginActivity::class.java)
                            startActivity(intent)
                        } else{
                            Toast.makeText(
                                baseContext, "failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                } else {
                    Log.w("Lakshmi", "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    //updateUI(null)
                }

            }

    }


}