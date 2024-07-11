package br.com.example.connect.page.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.example.connect.R
import br.com.example.connect.statics.PostList
import br.com.example.connect.type.Post
import br.com.example.connect.ui.theme.DarkGray
import br.com.example.connect.ui.theme.Primary
import br.com.example.connect.ui.theme.PrimaryTransparent3
import br.com.example.connect.ui.theme.TextFieldLabelStyle
import br.com.example.connect.util.DateUtil
import java.text.SimpleDateFormat

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostsPage() {
    Column (
        Modifier
            .fillMaxSize()
            .background(DarkGray)
    ) {

        // Exibindo 5 posts usando LazyColumn
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {

            item { Spacer(Modifier.height(116.dp)) }

            itemsIndexed(PostList.posts) { index, post ->
                PostCard(index, post)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostCard(index: Int, post: Post) {

    val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")

    val userPhoto = post.user.perfilPhoto
    val userName = post.user.name
    val hour = DateUtil.getHour(post.date)
    val date = DateUtil.formatDate(dateFormat.format(post.date))
    val description = post.description
    val mediaAmount = post.mediaList.size
    val likeAmout = post.info.likeAmount
    val commentAmout = post.info.commentAmount
    val shareAmount = post.info.shareAmount




    Card (
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Primary
        ),
        shape = RectangleShape
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = userPhoto),
                        contentDescription = "Profile Picture",
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Column {
                        Text(
                            text = userName,
                            style = TextFieldLabelStyle
                        )
                        Text(
                            text = "$hour h - $date",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.LightGray
                        )
                    }
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_more_options_horiz),
                        contentDescription = "Post More Options",
                        tint = Color.White
                    )
                }
            }

            Row (
                modifier = Modifier.padding(16.dp)
            ){
                Text(
                    text = description,
                    color = Color.White
                )
            }

            val pagerState = rememberPagerState()

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(4 / 3f)
                    .padding(16.dp)
            ) {

                HorizontalPager(
                    pageCount = mediaAmount,
                    state = pagerState,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center,

                        ) {

                        Image(
                            painter = painterResource(id = post.mediaList[it].mediaPath),
                            contentDescription = "Post Image",
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                    }
                }

                Text(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .background(
                            color = PrimaryTransparent3,
                            shape = RoundedCornerShape(4.dp)
                        )
                    ,
                    text = " ${pagerState.currentPage + 1}/$mediaAmount ",
                    color = Color.White
                )
            }

            //ROW LIKE COMENTAR E SHARE
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Like Button with Counter
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier.weight(1f),
                    onClick = { /* Handle like action */ }) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            modifier = Modifier.size(16.dp),
                            painter = painterResource(id = R.drawable.ic_like_unfilled),
                            contentDescription = "Like button",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = likeAmout.toString(),
                            color = Color.White,
                            style = TextFieldLabelStyle.copy(
                                fontSize = 14.sp
                            )
                        )
                    }
                }

                // Comment Button with Counter
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier.weight(1f),
                    onClick = { /* Handle comment action */ }) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            modifier = Modifier.size(16.dp),
                            painter = painterResource(id = R.drawable.ic_comment),
                            contentDescription = "Comment button",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = commentAmout.toString(),
                            color = Color.White,
                            style = TextFieldLabelStyle.copy(
                                fontSize = 14.sp
                            )
                        )
                    }
                }


                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier.weight(1f),
                    onClick = { /* Handle share action */ }) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            modifier = Modifier
                                .size(16.dp)
                                .offset(y = (-1).dp),
                            painter = painterResource(id = R.drawable.ic_reply),
                            contentDescription = "Share button",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = shareAmount.toString(),
                            color = Color.White,
                            style = TextFieldLabelStyle.copy(
                                fontSize = 14.sp
                            )
                        )
                    }
                }
            }

        }
    }
}
