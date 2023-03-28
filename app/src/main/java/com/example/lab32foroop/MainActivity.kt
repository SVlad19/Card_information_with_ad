package com.example.lab32foroop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab32foroop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val username = "vlad1923"
        val password = "1923"

        binding = ActivityMainBinding.inflate(layoutInflater)
        val intent = Intent(this,InfoWindow::class.java)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener(){
            if(binding.etUsername.text.toString() == username && binding.etPassword.text.toString() == password ){

            }
        }


    }
}