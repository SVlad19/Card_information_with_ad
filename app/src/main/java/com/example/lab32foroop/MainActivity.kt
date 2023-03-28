package com.example.lab32foroop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import com.example.lab32foroop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val FirstPerson  = Person("vlad1923","1923","5168 *** *** 0000","28 000 UAH","09/30")

        binding = ActivityMainBinding.inflate(layoutInflater)
        val intent = Intent(this,InfoWindow::class.java)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener(){
            if(binding.etUsername.text.toString() == FirstPerson.username && binding.etPassword.text.toString() == FirstPerson.password ){

                startActivity(intent.apply { putExtra("person",FirstPerson) })
            }else{
                binding.etUsername.setText("")
                binding.etPassword.setText("")
            }
        }
    }
    override fun onResume() {
        super.onResume()
        binding.etUsername.setText("")
        binding.etPassword.setText("")
    }

}