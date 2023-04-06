package com.example.sayitahminoyunu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.example.sayitahminoyunu.databinding.ActivityMainLoseEkranBinding


class MainLoseEkran : AppCompatActivity() {
    private lateinit var binding: ActivityMainLoseEkranBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        countDown()
    }
    //kaybettiniz yazısından önceki sayacı olusturur
    fun countDown() {
        object : CountDownTimer(3000, 1000) {
            override fun onFinish() {
                binding.loseText.text = "Kaybettiniz tekrar deneyin :("

            }

            override fun onTick(p0: Long) {
                binding.loseText.text = "${p0 / 1000}"
            }
        }.start()
    }
    //tekrar oynamak için oyun sayfasına iletir
    fun againButtonClick(view: View){
        intent= Intent(applicationContext,MainAnaEkran::class.java)
        startActivity(intent)
    }
    //çıkıs yapar
    fun loseButtonClick(view: View){
        intent= Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)
    }
    fun setupBinding(){
        binding = ActivityMainLoseEkranBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

    }

}