package com.example.splitwise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_contacts_list.*

class ContactsListActivity : AppCompatActivity() {
    private val databaseReference = FirebaseDatabase.getInstance().getReference("Users")
    private  var dataList= mutableListOf<Database>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts_list)
        addFriendToDatabase.setOnClickListener {
            databaseReference.addValueEventListener(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    dataList.clear()
                    for(i in snapshot.children){
                        val data:Database=i.getValue(Database::class.java)!!
                        if(data.userId!= Firebase.auth.currentUser?.uid){
                            dataList.add(data)
                        }
                    }
                    setAdapter(dataList)

                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }
    }

    private fun setAdapter(dataList: List<Database>) {



    }
}