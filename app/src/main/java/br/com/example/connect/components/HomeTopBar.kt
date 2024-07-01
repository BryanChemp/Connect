package br.com.example.connect.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.example.connect.R
import br.com.example.connect.ui.theme.ButtonTextStyle
import br.com.example.connect.ui.theme.PrimaryTransparent2

@Composable
fun HomeTopBar(
    pageIndex : Int
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(PrimaryTransparent2)
                .padding(start = 24.dp, end = 24.dp, top = 48.dp, bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.logo_dark),
                    contentDescription = "Logo",
                    tint = Color.Unspecified
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "Connect",
                    style = ButtonTextStyle.copy(
                        fontSize = 18.sp
                    ),
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(28.dp),
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Logo",
                    tint = Color.White
                )

                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    modifier = Modifier.size(28.dp),
                    painter = painterResource(id = R.drawable.ic_more_options_vert),
                    contentDescription = "Logo",
                    tint = Color.White
                )
            }
        }
        
        Spacer(modifier = Modifier.fillMaxWidth().height(0.5.dp).background(Color.White))
    }
}
