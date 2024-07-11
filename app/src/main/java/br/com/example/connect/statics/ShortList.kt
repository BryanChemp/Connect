package br.com.example.connect.statics

import android.annotation.SuppressLint
import br.com.example.connect.type.Shorts
import java.text.SimpleDateFormat

class ShortList {
    companion object {
        @SuppressLint("SimpleDateFormat")
        private val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")

        val shorts : List<Shorts> = listOf(
            Shorts(
                user = Users.user1,
                video = MediaList.mediasPost1[0],
                description = "Post 1",
                date = dateFormat.parse("07/07/2024 14:30")!!,
                info = PostInfos.postInfo1
            ),
            Shorts(
                user = Users.user2,
                video = MediaList.mediasPost2[0],
                description = "Post 2",
                date = dateFormat.parse("01/08/2002 12:10")!!,
                info = PostInfos.postInfo2
            ),
            Shorts(
                user = Users.user2,
                video = MediaList.mediasPost1[0],
                description = "Post 2",
                date = dateFormat.parse("01/08/2002 12:10")!!,
                info = PostInfos.postInfo2
            )
        )
    }

}