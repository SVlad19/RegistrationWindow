package com.example.lab21foroop

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab21foroop.databinding.ActivityChangeUsernameBinding

class ChangeUsername : AppCompatActivity() {
    private lateinit var binding: ActivityChangeUsernameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangeUsernameBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnOk.setOnClickListener(){
            val resultIntent = Intent(this,MainActivity::class.java)
            resultIntent.putExtra("Username",binding.etNewnickname.text.toString())
            setResult(Activity.RESULT_OK,resultIntent)
            finish()
        }

    }
}