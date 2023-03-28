package com.example.lab32foroop

import android.app.Activity
import android.app.PendingIntent.OnFinished
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import com.example.lab32foroop.databinding.ActivityInfoWindowBinding
import java.lang.reflect.Constructor
import java.time.Year

class InfoWindow : AppCompatActivity() {
    private lateinit var binding: ActivityInfoWindowBinding
    private var timer: CountDownTimer? = null

    fun changeData(binding : ActivityInfoWindowBinding, person: Person){
        binding.tvNumbers.setText(person.numberCard)
        binding.tvYear.setText(person.year)
        binding.tvMoney.setText(person.amountMoney)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val AdIntent = Intent(this,AdActivity::class.java)

        binding = ActivityInfoWindowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startCountDownTimer(10000,AdIntent)

        val person = intent.getSerializableExtra("person") as Person
        changeData(binding,person)

        binding.btnBack.setOnClickListener(){
            timer?.cancel()
            var resultIntent = Intent(this,MainActivity::class.java)
            resultIntent.putExtra("info",1)
            setResult(Activity.RESULT_OK,resultIntent)
            finish()
        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    private fun startCountDownTimer(timeMillis: Long, AdIntent: Intent){
        timer?.cancel()
        timer = object : CountDownTimer(timeMillis, 1){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                startActivity(AdIntent)
            }

        }.start()

    }
}