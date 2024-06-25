package br.com.example.connect.screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.example.connect.R
import br.com.example.connect.components.VersionField
import br.com.example.connect.ui.theme.ButtonTextStyle
import br.com.example.connect.ui.theme.MyTypography
import br.com.example.connect.ui.theme.Primary
import br.com.example.connect.ui.theme.PrimaryTransparent
import kotlinx.coroutines.launch

@Composable
fun PreScreen(){
    val scope = rememberCoroutineScope()
    val offsetY = remember { Animatable(0f) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.bg_pre_screen),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 160.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom

        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = PrimaryTransparent)
            ){
                Column (
                    Modifier.padding(horizontal = 32.dp)
                ){
                    Text(
                        text = "Você conectado\nsempre",
                        color = Color.White,
                        style = MyTypography.titleLarge,
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(
                            topStart = 32.dp,
                            topEnd = 32.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 0.dp
                        )
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ){

                Column (
                    Modifier
                        .fillMaxWidth(0.8f)
                        .padding(top = 52.dp, bottom = 44.dp)
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {/* TODO */},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Primary
                        ),
                        shape = RoundedCornerShape(
                            20.dp
                        ),
                        contentPadding = PaddingValues(
                            vertical = 14.dp
                        )
                    ) {
                        Text(
                            text = "Criar uma conta",
                            style = ButtonTextStyle.copy(
                                color = Color.White
                            )
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {/* TODO */},
                        border = BorderStroke(
                            4.dp,
                            Primary
                        ),
                        shape = RoundedCornerShape(
                            20.dp
                        ),
                        contentPadding = PaddingValues(
                            vertical = 14.dp
                        )
                    ) {
                        Text(
                            text = "Já tenho uma conta",
                            style = ButtonTextStyle.copy(
                                color = Primary
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Dúvidas frequentes",
                        style = MyTypography.labelMedium.copy(
                            color = Primary,
                            textDecoration = TextDecoration.Underline,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }

            VersionField()
        }
    }
}