package br.com.example.connect.type

import java.util.Date

data class Shorts (
    val user : User,
    val video : Media,
    val description : String,
    val date : Date,
    val info : PostInfo
)