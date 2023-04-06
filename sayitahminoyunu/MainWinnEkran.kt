package com.example.sayitahminoyunu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.sayitahminoyunu.databinding.ActivityMainBinding
import com.example.sayitahminoyunu.databinding.ActivityMainWinnEkranBinding

class MainWinnEkran : AppCompatActivity() {
    private lateinit var binding: ActivityMainWinnEkranBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        countDown()
    }
    //tebrikler yazısından önceki sayacı olusturur
    fun countDown(){
        object : CountDownTimer(3000,1000) {
            override fun onFinish() {
                binding.counterText.text = "Tebrikler :)"

            }

            override fun onTick(p0: Long) {
                binding.counterText.text="${p0/1000}"
            }
        }.start()

    }
    fun setupBinding(){
        binding = ActivityMainWinnEkranBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

    }
}