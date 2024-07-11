package br.com.example.connect.page.home

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.example.connect.R
import br.com.example.connect.statics.PostList
import br.com.example.connect.statics.ShortList
import br.com.example.connect.type.Shorts
import br.com.example.connect.ui.theme.Primary
import br.com.example.connect.ui.theme.PrimaryTransparent3
import br.com.example.connect.ui.theme.TextFieldLabelStyle
import br.com.example.connect.ui.theme.White
import br.com.example.connect.util.DateUtil
import java.text.SimpleDateFormat

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ShortsPage() {
    val pagerState = rememberPagerState()

    val shorts = ShortList.shorts

    Scaffold(
        Modifier
            .fillMaxSize()
            .background(Color.DarkGray),
    ) {

        Column(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f),
            ) {

                VerticalPager(
                    pageCount = shorts.size,
                    state = pagerState,
                    modifier = Modifier.fillMaxSize()
                ) { page ->
                    Short(short = shorts[page])
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Short(short: Shorts) {

    val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")

    val userPhoto = short.user.perfilPhoto
    val userName = short.user.name
    val hour = DateUtil.getHour(short.date)
    val date = DateUtil.formatDate(dateFormat.format(short.date))
    val description = short.description
    val likeAmout = short.info.likeAmount
    val commentAmout = short.info.commentAmount
    val shareAmount = short.info.shareAmount

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary),
        contentAlignment = Alignment.Center,
    ) {

        Image(
            painter = painterResource(id = short.video.mediaPath),
            contentDescription = "Shorts Video",
            modifier = Modifier.fillMaxSize(),
        )

        Column(
            Modifier
                .padding(16.dp)
                .align(Alignment.BottomStart)
        ) {
            Row(
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

            Text(text = description)
        }

        Column (
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 48.dp)
                .align(Alignment.BottomEnd)
        ){
            IconButton(
                modifier = Modifier.background(
                    color = White,
                    shape = RoundedCornerShape(500.dp)
                ),
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_like_unfilled),
                    contentDescription = "Like Shorts Button",
                    tint = Primary
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            IconButton(
                modifier = Modifier.background(
                    color = White,
                    shape = RoundedCornerShape(500.dp)
                ),
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_comment),
                    contentDescription = "Comment Shorts Button",
                    tint = Primary
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            IconButton(
                modifier = Modifier.background(
                    color = White,
                    shape = RoundedCornerShape(500.dp)
                ),
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_reply),
                    contentDescription = "Reply Shorts Button",
                    tint = Primary
                )
            }
        }
    }
}
