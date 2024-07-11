package br.com.example.connect.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.example.connect.R
import br.com.example.connect.ui.theme.Primary
import br.com.example.connect.ui.theme.PrimaryTransparent3
import br.com.example.connect.ui.theme.White




@Composable
fun MessagesActionBtn () {
    Box(
        Modifier.padding(16.dp)
    ) {
        IconButton(
            modifier = Modifier.background(
                color = White,
                shape = RoundedCornerShape(500.dp)
            ),
            onClick = { /*TODO*/ },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_like_unfilled),
                contentDescription = "New Chat Button",
                tint = Primary
            )
        }
    }
}