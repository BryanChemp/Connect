package br.com.example.connect.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import br.com.example.connect.R
import br.com.example.connect.ui.theme.TextFieldValueStyle
import br.com.example.connect.ui.theme.poppinsFamily


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextField(
    label: String,
    value: MutableState<TextFieldValue>
) {
    TextField(
        value = value.value,
        onValueChange = { newText -> value.value = newText },
        label = {
            Text(
                text = label,
                style = TextStyle(
                    fontFamily = poppinsFamily,
                    fontSize = 16.sp
                )
            )
        },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.Gray,
            cursorColor = Color.White,
            textColor = Color.White,
            unfocusedLabelColor = Color.Gray,
            focusedLabelColor = Color.Gray
        ),
        singleLine = true,
        maxLines = 1,
        textStyle = TextFieldValueStyle
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithIconBtn(
    label: String,
    value: MutableState<TextFieldValue>,
    trailingIcon: @Composable (() -> Unit)? = null,
    onTrailingIconClick: () -> Unit = {}
) {
    TextField(
        value = value.value,
        onValueChange = { newText -> value.value = newText },
        label = {
            Text(
                text = label,
                style = TextStyle(
                    fontFamily = poppinsFamily,
                    fontSize = 16.sp
                )
            )
        },
        trailingIcon = {
            if (trailingIcon != null) {
                Box(modifier = Modifier.clickable { onTrailingIconClick() }) {
                    trailingIcon()
                }
            }
        },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.Gray,
            cursorColor = Color.White,
            textColor = Color.White,
            unfocusedLabelColor = Color.Gray,
            focusedLabelColor = Color.Gray
        ),
        singleLine = true,
        maxLines = 1,
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp)
    )
}

@Composable
fun PasswordTextField(
    label: String,
    value: MutableState<TextFieldValue>
) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    TextFieldWithIconBtn(
        label = label,
        value = value,
        trailingIcon = {
            Icon(
                painter = painterResource(id = if (isPasswordVisible) R.drawable.ic_open_eye else R.drawable.ic_closed_eye),
                contentDescription = if (isPasswordVisible) "Hide password" else "Show password",
                tint = Color.White
            )
        },
        onTrailingIconClick = {
            isPasswordVisible = !isPasswordVisible
        }
    )
}