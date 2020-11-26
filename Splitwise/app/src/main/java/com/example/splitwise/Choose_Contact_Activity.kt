package com.example.splitwise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_choose__contact_.*

class Choose_Contact_Activity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose__contact_)
        firebaseAuth = FirebaseAuth.getInstance()
        btnAddThisFriend.setOnClickListener{
            val contact = etEnteredPhoneNo.text.toString()
            addfriend(contact)
        }
    }

    private fun addfriend(contact:String) {

       val userId = firebaseAuth.currentUser?.uid
        val  firebaseReference = FirebaseDatabase.getInstance().getReference("Users")
        firebaseReference.addValueEventListener(object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                for (i in snapshot.children){
                    var database = i.getValue(Database::class.java)
                    if (database?.userId==userId){
                        val friendsList = database?.friendList

                        val friend = Friends(contact)
                        friendsList?.add(friend)
                        val new_database = Database(userId!!,database.email,database.phoneNo,database.name,database.imageUrl,friendsList!!)
                        firebaseReference.child(userId)

                    }
                }
            }

        })



        val reference = FirebaseDatabase.getInstance().getReference("Users").child("-MMyljHN52aYwehc4z-L")
        reference.addValueEventListener(object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {

            }

        })

//        reference.setValue()



    }

    private fun putnewData(database: Database,contact: String) {
        val friend = Friends(contact, mutableListOf<Transactions>())
        database.friendList.add(friend)
//        firebaseReference.setValue(database)

    }
}