package br.com.example.connect.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.example.connect.ui.theme.ButtonTextStyle
import br.com.example.connect.ui.theme.Primary
import br.com.example.connect.ui.theme.VersionTextStyle

@Composable
fun VersionField() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(Primary),
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            modifier = Modifier.padding(24.dp),
            text = "1.0.0",
            style = VersionTextStyle.copy(
                color = Color.White,
            )
        )
    }
}