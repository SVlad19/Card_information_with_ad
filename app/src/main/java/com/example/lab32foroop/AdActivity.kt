package com.example.lab32foroop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.lab32foroop.databinding.ActivityAdBinding
import com.example.lab32foroop.databinding.ActivityInfoWindowBinding
import java.net.URI

class AdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdBinding
    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val videoPath = "android.resource://" + packageName + "/" + R.raw.ad
        binding.vvAd.setVideoPath(videoPath)

        binding.vvAd.start()
        startCountDownTimer(10000)

    }

    private fun startCountDownTimer(timeMillis: Long) {
        timer?.cancel()
        timer = object : CountDownTimer(timeMillis, 1) {
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                finish()
            }

        }.start()
    }
}