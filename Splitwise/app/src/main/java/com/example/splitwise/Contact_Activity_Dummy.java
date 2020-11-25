package com.example.splitwise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Contact_Activity_Dummy extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact___dummy);
        launchFragment();
        fp_get_Android_Contacts();
    }

    private void launchFragment() {
        ContactsFragment contactsFragment=new ContactsFragment();
        fragmentManager.beginTransaction().replace(R.id.flContainer,contactsFragment,"fragment").addToBackStack("fragment").commit();
    }

    public class Android_Contact {
        public String android_contact_Name = "";
        public String android_contact_TelefonNr = "";
        public int android_contact_ID = 0;
    }

    public void fp_get_Android_Contacts() {
        ArrayList<Android_Contact> arrayList_Android_Contacts = new ArrayList<Android_Contact>();

        Cursor cursor_Android_Contacts = null;
        ContentResolver contentResolver = getContentResolver();
        try {
            cursor_Android_Contacts = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        } catch (Exception ex) {
            Log.e("Error on contact", ex.getMessage());
        }

        if (cursor_Android_Contacts.getCount() > 0) {
            while (cursor_Android_Contacts.moveToNext()) {
                Android_Contact android_contact = new Android_Contact();
                String contact_id = cursor_Android_Contacts.getString(cursor_Android_Contacts.getColumnIndex(ContactsContract.Contacts._ID));
                String contact_display_name = cursor_Android_Contacts.getString(cursor_Android_Contacts.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                android_contact.android_contact_Name = contact_display_name;


                int hasPhoneNumber = Integer.parseInt(cursor_Android_Contacts.getString(cursor_Android_Contacts.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
                if (hasPhoneNumber > 0) {

                    Cursor phoneCursor = contentResolver.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI
                            , null
                            , ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?"
                            , new String[]{contact_id}
                            , null);

                    while (phoneCursor.moveToNext()) {
                        String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        android_contact.android_contact_TelefonNr = phoneNumber;

                    }
                    phoneCursor.close();
                }

                arrayList_Android_Contacts.add(android_contact);
            }

//            Adapter_for_Android_Contacts adapter = new Adapter_for_Android_Contacts(this, arrayList_Android_Contacts);
//            listview_Android_Contacts.setAdapter(adapter);


        }

    }


    public class Adapter_for_Android_Contacts extends BaseAdapter {

        Context mContext;
        List<Android_Contact> mList_Android_Contacts;

        public Adapter_for_Android_Contacts(Context mContext, List<Android_Contact> mContact) {
            this.mContext = mContext;
            this.mList_Android_Contacts = mContact;
        }
//</ constructor with ListArray >

        @Override
        public int getCount() {
            return mList_Android_Contacts.size();
        }

        @Override
        public Object getItem(int position) {
            return mList_Android_Contacts.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(mContext, R.layout.item_layout_contact_list, null);
            TextView textview_contact_Name = (TextView) view.findViewById(R.id.textview_android_contact_name);
            TextView textview_contact_TelefonNr = (TextView) view.findViewById(R.id.textview_android_contact_phoneNr);

            textview_contact_Name.setText(mList_Android_Contacts.get(position).android_contact_Name);
            textview_contact_TelefonNr.setText(mList_Android_Contacts.get(position).android_contact_TelefonNr);


            view.setTag(mList_Android_Contacts.get(position).android_contact_Name);
            return view;
        }

    }

}