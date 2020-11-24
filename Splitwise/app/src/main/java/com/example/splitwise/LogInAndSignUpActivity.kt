package com.example.splitwise

import android.content.Intent
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_log_in_and_sign_up.*

class LogInAndSignUpActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var googleSignInOptions: GoogleSignInOptions
    private lateinit var googleSignInClient: GoogleSignInClient
    private val SIGNIN_REQ_CODE = 101
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_and_sign_up)
        initbuttons()
        initData()
    }
    fun initbuttons(){
        btnlogin.setOnClickListener(this)
        btnsignup.setOnClickListener(this)
        btnsignwithgoogle.setOnClickListener(this)
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
            R.id.btnsignwithgoogle -> {
                val signInIntent = googleSignInClient.signInIntent
                startActivityForResult(signInIntent, SIGNIN_REQ_CODE)
            }
        }
    }
    private fun initData() {
        googleSignInOptions= GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        auth = Firebase.auth
        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SIGNIN_REQ_CODE) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)
                Log.d("TAG", "firebaseAuthWithGoogle:" + account?.id)
                firebaseAuthWithGoogle(account?.idToken)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                // ...
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String?) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    Snackbar.make(rlParent, "SigIn successfull", Snackbar.LENGTH_SHORT).show()
                    UpdateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    // ...
                    println("Failure")
                    Snackbar.make(rlParent, "Authentication Failed.", Snackbar.LENGTH_SHORT).show()
                }

            }

    }
    private fun UpdateUI(user : FirebaseUser?){
        val intent=Intent(this@LogInAndSignUpActivity,Splitwise_HomeActivity::class.java)
        startActivity(intent)
    }
}