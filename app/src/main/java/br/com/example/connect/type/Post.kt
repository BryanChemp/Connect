package br.com.example.connect.type

import java.util.Date

data class Post (
    val user : User,
    val mediaList : List<Media>,
    val description : String,
    val date : Date,
    val info : PostInfo
)