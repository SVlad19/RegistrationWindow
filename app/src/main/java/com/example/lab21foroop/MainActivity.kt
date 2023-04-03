package com.example.lab21foroop

import android.app.DownloadManager.Request
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab21foroop.databinding.ActivityChangeUsernameBinding
import com.example.lab21foroop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val REQUEST_CODE = 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val intent = Intent(this,ChangeUsername::class.java)

        binding.TVUserName.setOnClickListener(){
            startActivityForResult(intent,3)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE){
            binding.TVUserName.setText(data?.getStringExtra("Username"))
        }

    }
}