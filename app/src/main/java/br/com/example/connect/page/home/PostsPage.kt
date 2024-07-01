package br.com.example.connect.page.home

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.example.connect.R
import br.com.example.connect.ui.theme.Primary
import br.com.example.connect.ui.theme.TextFieldLabelStyle

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostsPage() {
    Column (
        Modifier
            .fillMaxSize()
            .background(Primary)
    ) {

        // Exibindo 5 posts usando LazyColumn
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {

            item { Spacer(Modifier.height(128.dp)) }

            itemsIndexed(listOf("Post 1", "Post 2", "Post 3", "Post 4", "Post 5")) { index, post ->
                Post(index, post)
                Spacer(modifier = Modifier.height(16.dp)) // Espaço entre os posts
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Post(index: Int, content: String) {
    Card (
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Primary
        )
    ) {
        Column {
            // Cabeçalho do post (foto, nome, etc)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.bg_login_screen),
                        contentDescription = "Profile Picture",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    // Coluna com nome e data
                    Column {
                        Text(
                            text = "Bryan Chemp",
                            style = TextFieldLabelStyle
                        )
                        Text(
                            text = "2h - ",
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

            // Conteúdo do post (texto, imagens, etc)
            Row (
                modifier = Modifier.padding(16.dp)
            ){
                Text(
                    text = content,
                    color = Color.White
                )
            }

            //ROW HORIZONTAL SCROLL COM AS IMAGENS EM UMA PROPORÇÃO ESPECIFICA
            val pagerState = rememberPagerState()

            HorizontalPager(
                pageCount = 5, // Número de imagens
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(4 / 3f)
                    .padding(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bg_register_screen),
                        contentDescription = "Post Image",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(MaterialTheme.shapes.medium),
                        contentScale = ContentScale.Crop
                    )
                }
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
                            text = "15",
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
                            text = "15",
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
                            text = "15",
                            color = Color.White,
                            style = TextFieldLabelStyle.copy(
                                fontSize = 14.sp
                            )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(Color.LightGray))
        }
    }
}
