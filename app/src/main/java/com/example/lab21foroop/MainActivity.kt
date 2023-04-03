package com.example.lab21foroop

import android.app.DownloadManager.Request
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import com.example.lab21foroop.databinding.ActivityChangeUsernameBinding
import com.example.lab21foroop.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val REQUEST_CODE_FOR_NICKNAME = 3
    private val REQUEST_CODE_FOR_IMAGE = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val intent = Intent(this,ChangeUsername::class.java)

        binding.TVUserName.setOnClickListener(){
            startActivityForResult(intent,3)
        }

        binding.btnLogIn.setOnClickListener(){
            binding.TVUserName.setText(binding.edLogin.text.toString())
            binding.llFirstLayout.visibility = View.GONE
        }

        binding.IVMainPhoto.setOnClickListener(){
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, REQUEST_CODE_FOR_IMAGE)


        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            REQUEST_CODE_FOR_NICKNAME ->
            {
                binding.TVUserName.setText(data?.getStringExtra("Username"))
            }

            REQUEST_CODE_FOR_IMAGE->
            {
                val imageUri = data?.data
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri)
                binding.IVMainPhoto.setImageBitmap(bitmap)
            }
            else ->{
                finishAffinity()
            }
        }



    }
}