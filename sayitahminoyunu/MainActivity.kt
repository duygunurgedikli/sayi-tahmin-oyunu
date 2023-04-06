package com.example.sayitahminoyunu

import android.content.Intent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.sayitahminoyunu.databinding.ActivityMainBinding
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        autoTextView()


    }
    //cinsiyet textinde otomatik doldurma saglar
    fun autoTextView(){
        val gender= listOf("Kız","Erkek")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, gender)
        val actv = findViewById<AutoCompleteTextView>(R.id.userGender)
        actv.setAdapter(adapter)
        actv.threshold=1//ilk harfe göre secimleri getirir
    }
    //oyun sayfasına giriş yapar
    fun enterButtonClick(view: View){
        val user=User()//user classından nesne olusturur
        user.userName=binding.userName.text.toString()//texte yazılanları nesnenin degişkenlerine atar
        user.gender=binding.userGender.text.toString()

        val SharedPreferences=this.getSharedPreferences("info", MODE_PRIVATE)
        val editor= SharedPreferences.edit()
        editor.putString("name","${user.userName}").apply()//nesnedeki verileri sharedpreferences yapısıyla kaydeder
        editor.putString("gender","${user.gender}").apply()



        binding.userName.text.clear()//textleri bosaltır
        binding.userGender.text.clear()

        if(user.gender=="Kız"||user.gender=="Erkek")//gecerli cinsiyet kosulunu kontrol eder
        {
            //kosul saglanıyorsa oyun ekranına iletir ve toast mesajla bilgi verilir
            intent= Intent(applicationContext,MainAnaEkran::class.java)
            startActivity(intent)
            Toast.makeText(applicationContext,"Giriş Başarılı",Toast.LENGTH_LONG).show()
        }
        else{
            //kosul saglanmazsa toast mesaj verir
            Toast.makeText(applicationContext,"Geçerli Cinsiyet Giriniz",Toast.LENGTH_LONG).show()
        }

    }



    fun setupBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

    }

}