package com.example.sayitahminoyunu

class User : userGender{
    //kullanıcı bilgilerini iceren class userGender classından inheritant alıyor
    var userName: String?=null

    //boş constructor
    constructor (){

    }

    constructor(name:String,userGender:String){
        this.userName=name
        this.gender=userGender
    }

}