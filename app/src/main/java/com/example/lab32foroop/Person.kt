package com.example.lab32foroop

class Person(_username: String,_password:String,_numberCard: String, _amountMoney: String,_year: String): java.io.Serializable{
    val username :String
    val password : String
    val numberCard :String
    val amountMoney :String
    val year :String


    init{
        username = _username
        password = _password
        numberCard = _numberCard
        amountMoney = _amountMoney
        year = _year
    }

}