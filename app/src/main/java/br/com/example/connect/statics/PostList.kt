package br.com.example.connect.statics

import android.annotation.SuppressLint
import br.com.example.connect.type.Media
import br.com.example.connect.type.Post
import java.text.SimpleDateFormat
import java.util.Date

class PostList {
    companion object {
        @SuppressLint("SimpleDateFormat")
        private val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")

        val posts : List<Post> = listOf(
            Post(
                user = Users.user1,
                mediaList = MediaList.mediasPost1,
                description = "Post 1",
                date = dateFormat.parse("07/07/2024 14:30")!!,
                info = PostInfos.postInfo1
            ),
            Post(
                user = Users.user2,
                mediaList = MediaList.mediasPost2,
                description = "Post 2",
                date = dateFormat.parse("01/08/2002 12:10")!!,
                info = PostInfos.postInfo2
            )
        )
    }

}