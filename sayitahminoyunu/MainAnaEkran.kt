package com.example.sayitahminoyunu

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast

import com.example.sayitahminoyunu.databinding.ActivityMainAnaEkranBinding


class MainAnaEkran : AppCompatActivity() {
    private lateinit var binding: ActivityMainAnaEkranBinding
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        welcomeTextEdit()
        val random = java.util.Random()
        val numberToGuess = random.nextInt(100) + 1
        println(numberToGuess)//dogru cevap durumunu kontrol edebilmek için random sayıyı yazdırır
        var count=4


       //  button hareketlerini dinler
        binding.checkButton.setOnClickListener(){
       do
        {
        val userInput = binding.guessEnter.text.toString()
        val userGuess = userInput?.toIntOrNull()


        if(userGuess==null)
        {
            //bos tahmin degerinde toast mesaj verme
            Toast.makeText(applicationContext,"Geçerli bir değer giriniz",Toast.LENGTH_LONG).show()
        }
        else if(userGuess>100)
        {
            //yalıs aralık degerinde toast mesaj verme
            Toast.makeText(applicationContext,"1-100 arası bir değer giriniz",Toast.LENGTH_LONG).show()
        }
        //tahmin durumları
        else{
            if(userGuess<numberToGuess)
            {
                binding.result.text="Daha büyük bir sayı giriniz"
            }
            else if(userGuess>numberToGuess)
            {
                binding.result.text="Daha küçük bir sayı giriniz"
            }
            else if(userGuess==numberToGuess)
            {
                //dogru cevap sonucu tebrik sayfasına iletir
                intent= Intent(applicationContext,MainWinnEkran::class.java)
                startActivity(intent)
                break
            }
            count--
              //ekrana kalan hakları yazdırır
              binding.countText.text="kalan hakkınız: "+count.toString()

            }
        if(count==0)
        {   //haklar bittiginde kaybettiniz sayfasına iletir
            intent= Intent(applicationContext,MainLoseEkran::class.java)
            startActivity(intent)
            break
        }


        }while (userGuess==numberToGuess||count==0)//dongu kosulları


      }


    }

    //cinsiyet seçimine göre hitap şeklini belirleyip hosgeldin textini yazdıran metot
    fun welcomeTextEdit(){
        preferences=getSharedPreferences("info", MODE_PRIVATE)
        var userIn= preferences.getString("name","")

        var genderIn=preferences.getString("gender","")
          if(genderIn=="Kız")
          {
              binding.welcomeText.text="Hoşgeldiniz "+userIn.toString()+" Hanım"
          }
          else if(genderIn=="Erkek")
          {
              binding.welcomeText.text="Hoşgeldiniz "+userIn.toString()+" Bey"
          }


    }
    //giriş sayfasına donmeyi sağlayan fonksiyon
    fun exitButtonClick(view: View){

        val alert=AlertDialog.Builder(this)
        alert.setTitle("Çıkış")
        alert.setMessage("Çıkış yapmak istediğinize emin misiniz?")
        alert.setPositiveButton("Evet"){ dialog, which->
            intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(applicationContext,"Çıkış Başarılı", Toast.LENGTH_LONG).show()

        }
        alert.setNegativeButton("Hayır") { dialog, which->
            intent= Intent(applicationContext,MainAnaEkran::class.java)
            startActivity(intent)


        }
        alert.show()

    }


    fun setupBinding(){
        binding=ActivityMainAnaEkranBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

    }
}