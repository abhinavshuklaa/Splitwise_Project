package com.example.splitwise

import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class ContactsListActivity : AppCompatActivity() {
    open class Android_Contact{
        var android_contact_Name = ""
        var android_contact_TelefonNr = ""
        var android_contact_ID = 0
    }


//    private val databaseReference = FirebaseDatabase.getInstance().getReference("Users")
//    private  var dataList= mutableListOf<Database>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts_list)
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

//    fun fp_get_Android_contact(){
//        val arrayList_Android_Contacts = ArrayList<Android_Contact>()
//        var cursor_Android_Contacts: Cursor? = null
//        val contentResolver = contentResolver
//        try {
//            cursor_Android_Contacts =
//                contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null)
//        } catch (ex: Exception) {
//            ex.message?.let { Log.e("Error on contact", it) }
//        }
//
//        if (cursor_Android_Contacts != null) {
//            if (cursor_Android_Contacts.getCount() > 0) {
//                while (cursor_Android_Contacts.moveToNext()){
//                    val android_contact = Android_Contact()
//                    val contact_id = cursor_Android_Contacts.getString(
//                        cursor_Android_Contacts.getColumnIndex(ContactsContract.Contacts._ID)
//                    )
//                    val contact_display_name = cursor_Android_Contacts.getString(
//                        cursor_Android_Contacts.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
//
//                    )
//                    android_contact.android_contact_Name = contact_display_name;
//
//
//                   var  hasPhoneNumber = Integer.parseInt(cursor_Android_Contacts.getString(cursor_Android_Contacts.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
//                    if (hasPhoneNumber > 0) {
//
//                      var phoneCursor= contentResolver.query(
//                                ContactsContract.CommonDataKinds.Phone.CONTENT_URI
//                        , null
//                        , ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?"
//                        ,}
//                        , null);
//
//                }
//
//
//            }
//            }
//        }


    private fun setAdapter(dataList: List<Database>) {

    }



}