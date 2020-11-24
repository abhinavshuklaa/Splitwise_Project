package com.example.splitwise

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_splitwise__home.*
import java.io.FileNotFoundException
import java.io.InputStream


class Splitwise_HomeActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var fregmentAdapter_Splitwise_HomeActivity: FragmentAdapter_Splitwise_HomeActivity
    private val RESULT_LOAD_IMAGE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splitwise__home)
        setViewPagerAdapter()
        InitializingAndsettingViewPager()

    }
    private fun slideRight(){
        val slide = Slide()
        slide.setSlideEdge(Gravity.START)
        TransitionManager.beginDelayedTransition(linearlayout, slide)
        linearlayout.setVisibility(View.VISIBLE)
    }
    private fun slideft(){
        val slide = Slide()
        slide.setSlideEdge(Gravity.START)
        TransitionManager.beginDelayedTransition(linearlayout, slide)
        linearlayout.setVisibility(View.GONE)
    }


    private fun InitializingAndsettingViewPager() {
        viewPagerFragmentFriends.adapter = fregmentAdapter_Splitwise_HomeActivity
        tabLayoutFragmentFriends.setupWithViewPager(viewPagerFragmentFriends)
        ivMenu.setOnClickListener(this)
        linearlayout.setOnClickListener(this)
        UserImage.setOnClickListener(this)

    }

    private fun setViewPagerAdapter() {
        fregmentAdapter_Splitwise_HomeActivity = FragmentAdapter_Splitwise_HomeActivity(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT

        )

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ivMenu -> {
                slideRight()
            }
            R.id.linearlayout -> {
                slideft()
            }
            R.id.UserImage -> {
                if (isPermissionGranted()) {
                    openGallery();
                } else {
                    requestStoragePermissions();
                }

            }

        }
    }

    private fun openGallery() {
        val i = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        startActivityForResult(i, RESULT_LOAD_IMAGE)
    }

    @SuppressLint("NewApi")
    private fun requestStoragePermissions() {
        requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            val selectedImage: Uri? = data.data
            try {
                val imageStream: InputStream? = contentResolver.openInputStream(selectedImage!!)
                UserImage.setImageBitmap(BitmapFactory.decodeStream(imageStream))
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        if (requestCode == 2 && grantResults.size > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery()
            } else {
                Toast.makeText(this@Splitwise_HomeActivity, "Permission Denied ", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this@Splitwise_HomeActivity,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    }

}