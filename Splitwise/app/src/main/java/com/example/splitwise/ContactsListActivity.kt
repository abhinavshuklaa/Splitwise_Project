package com.example.splitwise

import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.AdapterView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_contacts_list.*


class ContactsListActivity : AppCompatActivity() {
    open class Android_Contact {
        var android_contact_Name = ""
        var android_contact_TelefonNr = ""
        var android_contact_ID = 0
    }


//    private val databaseReference = FirebaseDatabase.getInstance().getReference("Users")
//    private  var dataList= mutableListOf<Database>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts_list)
        read()
//        addFriendToDatabase.setOnClickListener {
//            databaseReference.addValueEventListener(object :ValueEventListener{
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    dataList.clear()
//                    for(i in snapshot.children){
//                        val data:Database=i.getValue(Database::class.java)!!
//                        if(data.userId!= Firebase.auth.currentUser?.uid){
//                            dataList.add(data)
//                        }
//                    }
//                    setAdapter(dataList)
//
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                    TODO("Not yet implemented")
//                }
//
//            })
//        }
    }

    fun read() {
        var cursor: Cursor? = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        )
        startManagingCursor(cursor)

        var from = arrayOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Phone._ID
        )

        var to = intArrayOf(android.R.id.text1, android.R.id.text2)

        var simple =
            SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from, to)

        listView.adapter=simple
//        val onItemClickListener=object :AdapterView.OnItemClickListener{
//            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                val cursor :Cursor= parent.getItemAtPosition(p2)
//                val item_ID = cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts._ID))
//                val item_DisplayName =
//                    cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
//                val item_HasPhoneNumber =
//                    cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))
//
//                val item_LookUp =
//                    cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.LOOKUP_KEY))
//
//                var item_PhoneNumber = ""
//                item_PhoneNumber = if (item_HasPhoneNumber > 0) {
//                    "Has phone number."
//                } else {
//                    "No number."
//                }
//
//                val item = """
//                    $item_ID: $item_DisplayName
//                    $item_PhoneNumber
//                    LOOKUP_KEY: $item_LookUp
//                    """.trimIndent()
//
//
//            }
//
//        }
//        listView.setOnItemClickListener(onItemClickListener)


    }


    private fun setAdapter(dataList: List<Database>) {

    }


}