package br.com.example.connect.statics

import br.com.example.connect.R
import br.com.example.connect.type.Media

class MediaList {


    companion object {
        val mediasPost1 : List<Media> = listOf(
            Media(
                type = "jpg",
                mediaPath = R.drawable.img2
            ),
            Media(
                type = "jpg",
                mediaPath = R.drawable.img3
            ),
            Media(
                type = "jpg",
                mediaPath = R.drawable.img4
            ),
        )

        val mediasPost2 : List<Media> = listOf(
            Media(
                type = "jpg",
                mediaPath = R.drawable.img1
            ),
        )
    }

}