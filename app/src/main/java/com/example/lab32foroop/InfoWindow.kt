package com.example.lab32foroop

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lab32foroop.databinding.ActivityInfoWindowBinding
import java.lang.reflect.Constructor
import java.time.Year

class InfoWindow : AppCompatActivity() {
    private lateinit var binding: ActivityInfoWindowBinding

    fun changeData(binding : ActivityInfoWindowBinding, person: Person){
        binding.tvNumbers.setText(person.numberCard)
        binding.tvYear.setText(person.year)
        binding.tvMoney.setText(person.amountMoney)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoWindowBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val person = intent.getSerializableExtra("person") as Person

        changeData(binding,person)

        binding.btnBack.setOnClickListener(){
            var resultIntent = Intent(this,MainActivity::class.java)
            resultIntent.putExtra("info",1)
            setResult(Activity.RESULT_OK,resultIntent)
            finish()
        }

    }
}