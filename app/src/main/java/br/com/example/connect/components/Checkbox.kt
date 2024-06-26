package br.com.example.connect.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.example.connect.ui.theme.Primary

@Composable
fun SimpleCheckbox(
    text: String,
    isChecked: MutableState<Boolean>
){
    Row (
        verticalAlignment = Alignment.CenterVertically
    ){
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = !isChecked.value },
            colors = CheckboxDefaults.colors(
                checkmarkColor = Primary,
                uncheckedColor = Color.LightGray,
                checkedColor = Color.White
            )
        )
        Text(
            text = text,
            style = TextStyle(
                textDecoration = TextDecoration.Underline,
                color = Color.White,
                fontSize = 16.sp,
            )
        )

        Spacer(modifier = Modifier.width(16.dp))
    }
}