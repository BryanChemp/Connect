package br.com.example.connect.statics

import br.com.example.connect.R
import br.com.example.connect.type.Media
import br.com.example.connect.type.PostInfo

class PostInfos {


    companion object {
        val postInfo1 : PostInfo = PostInfo(
            likeAmount = 15,
            commentAmount = 8,
            shareAmount = 2
        )

        val postInfo2 : PostInfo = PostInfo(
            likeAmount = 122,
            commentAmount = 12,
            shareAmount = 16
        )

        val postInfo3 : PostInfo = PostInfo(
            likeAmount = 84,
            commentAmount = 32,
            shareAmount = 10
        )

        val postInfo4 : PostInfo = PostInfo(
            likeAmount = 8,
            commentAmount = 1,
            shareAmount = 0
        )

        val postInfo5 : PostInfo = PostInfo(
            likeAmount = 15,
            commentAmount = 14,
            shareAmount = 1
        )
    }

}