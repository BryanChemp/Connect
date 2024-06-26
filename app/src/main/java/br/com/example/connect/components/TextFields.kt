package br.com.example.connect.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.example.connect.R
import br.com.example.connect.ui.theme.TextFieldValueStyle
import br.com.example.connect.ui.theme.poppinsFamily


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextField(
    label: String,
    value: MutableState<TextFieldValue>,
    errorMsg: MutableState<String>
) {

    var count = remember {mutableStateOf(0)}

    TextField(
        value = value.value,
        onValueChange = { newText ->
            value.value = newText
            count.value++
            if(count.value > 5){
                errorMsg.value = ""
                count.value = 0
            }
        },
        label = {
            Text(
                text = label,
                style = TextStyle(
                    fontFamily = poppinsFamily,
                    fontSize = 14.sp
                )
            )
        },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.LightGray,
            cursorColor = Color.White,
            textColor = Color.White,
            unfocusedLabelColor = Color.LightGray,
            focusedLabelColor = Color.LightGray,
            focusedSupportingTextColor = Color.White,
            unfocusedSupportingTextColor = Color.LightGray
        ),
        singleLine = true,
        maxLines = 1,
        textStyle = TextFieldValueStyle,
        supportingText = {
            Text(text = errorMsg.value)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextFieldWithoutLabel(
    placeholder: String,
    value: MutableState<TextFieldValue>,
    errorMsg: MutableState<String>,
) {

    var count = remember {mutableStateOf(0)}

    TextField(
        value = value.value,
        onValueChange = { newText ->
            value.value = newText
            count.value++
            if(count.value > 5){
                errorMsg.value = ""
                count.value = 0
            }
        },
        placeholder = {
            Text(
                text = placeholder,
                style = TextStyle(
                    fontFamily = poppinsFamily,
                    fontSize = 14.sp
                )
            )
        },
        modifier = Modifier
            .fillMaxWidth()
        ,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.LightGray,
            cursorColor = Color.White,
            textColor = Color.White,
            focusedSupportingTextColor = Color.White,
            unfocusedSupportingTextColor = Color.LightGray,
            placeholderColor = Color.LightGray
        ),
        singleLine = true,
        maxLines = 1,
        textStyle = TextFieldValueStyle,
        supportingText = {
            Text(text = errorMsg.value)
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithIconBtn(
    label: String,
    value: MutableState<TextFieldValue>,
    trailingIcon: @Composable (() -> Unit)? = null,
    onTrailingIconClick: () -> Unit = {},
    visualTransformation: VisualTransformation = VisualTransformation.None,
    errorMsg: MutableState<String>
) {
    var count = remember {mutableStateOf(0)}

    TextField(
        value = value.value,
        onValueChange = { newText ->
            value.value = newText
            count.value++
            if(count.value > 5){
                errorMsg.value = ""
                count.value = 0
            }
        },
        label = {
            Text(
                text = label,
                style = TextStyle(
                    fontFamily = poppinsFamily,
                    fontSize = 14.sp
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
        visualTransformation = visualTransformation,
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.LightGray,
            cursorColor = Color.White,
            textColor = Color.White,
            unfocusedLabelColor = Color.LightGray,
            focusedLabelColor = Color.LightGray,
            focusedSupportingTextColor = Color.White,
            unfocusedSupportingTextColor = Color.LightGray
        ),
        singleLine = true,
        maxLines = 1,
        textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
        supportingText = {
            Text(text = errorMsg.value)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithIconBtnWithouLabel(
    placeholder: String,
    value: MutableState<TextFieldValue>,
    trailingIcon: @Composable (() -> Unit)? = null,
    onTrailingIconClick: () -> Unit = {},
    visualTransformation: VisualTransformation = VisualTransformation.None,
    errorMsg: MutableState<String>
) {
    var count = remember {mutableStateOf(0)}

    TextField(
        value = value.value,
        onValueChange = { newText ->
            value.value = newText
            count.value++
            if(count.value > 5){
                errorMsg.value = ""
                count.value = 0
            }
        },
        placeholder = {
            Text(
                text = placeholder,
                style = TextStyle(
                    fontFamily = poppinsFamily,
                    fontSize = 14.sp
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
        visualTransformation = visualTransformation,
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.LightGray,
            cursorColor = Color.White,
            textColor = Color.White,
            focusedSupportingTextColor = Color.White,
            unfocusedSupportingTextColor = Color.LightGray,
            placeholderColor = Color.LightGray
        ),
        singleLine = true,
        maxLines = 1,
        textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
        supportingText = {
            Text(text = errorMsg.value)
        }
    )
}

@Composable
fun PasswordTextField(
    label: String,
    value: MutableState<TextFieldValue>,
    errorMsg: MutableState<String>
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
        },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        errorMsg = errorMsg
    )
}

@Composable
fun PasswordTextFieldWithoutLabel(
    placeholder: String,
    value: MutableState<TextFieldValue>,
    errorMsg: MutableState<String>,
    isPasswordVisible: MutableState<Boolean>
) {

    TextFieldWithIconBtnWithouLabel(
        placeholder = placeholder,
        value = value,
        trailingIcon = {
            Icon(
                painter = painterResource(id = if (isPasswordVisible.value) R.drawable.ic_open_eye else R.drawable.ic_closed_eye),
                contentDescription = if (isPasswordVisible.value) "Hide password" else "Show password",
                tint = Color.White
            )
        },
        onTrailingIconClick = {
            isPasswordVisible.value = !isPasswordVisible.value
        },
        visualTransformation = if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        errorMsg = errorMsg
    )
}

@Composable
fun PasswordTextFieldWithoutLabelAndButton(
    placeholder: String,
    value: MutableState<TextFieldValue>,
    errorMsg: MutableState<String>,
    isPasswordVisible: MutableState<Boolean>
) {

    TextFieldWithIconBtnWithouLabel(
        placeholder = placeholder,
        value = value,
        visualTransformation = if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        errorMsg = errorMsg
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun CodeTextField(
    codeValues: List<MutableState<TextFieldValue>>,
    codeLength: Int
) {

    val focusManager = LocalFocusManager.current

    Row(
        Modifier.fillMaxWidth()
    ) {
        for (i in 0 until codeLength){

            if(i > 0) {
                Spacer(modifier = Modifier.width(4.dp))
            }

            TextField(
                value = codeValues[i].value,
                onValueChange = { newText ->
                    if (newText.text.length <= 1) {
                        codeValues[i].value = newText
                        if (newText.text.isNotEmpty() && i < codeLength - 1) {
                            focusManager.moveFocus(FocusDirection.Next)
                        }
                    }
                },
                placeholder = {
                    Text(
                        text = "",
                        style = TextStyle(
                            fontFamily = poppinsFamily,
                            fontSize = 14.sp
                        )
                    )
                },
                modifier = Modifier
                    .weight(1f)
                    .onKeyEvent { event ->
                        if (event.key == Key.Backspace && codeValues[i].value.text.isEmpty() && i > 0) {
                            codeValues[i - 1].value = TextFieldValue("")
                            focusManager.moveFocus(FocusDirection.Previous)
                            true
                        } else {
                            false
                        }
                    },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.LightGray,
                    cursorColor = Color.White,
                    textColor = Color.White,
                    focusedSupportingTextColor = Color.White,
                    unfocusedSupportingTextColor = Color.LightGray,
                    placeholderColor = Color.LightGray
                ),
                singleLine = true,
                maxLines = 1,
                textStyle = TextFieldValueStyle.copy(
                    textAlign = TextAlign.Center,
                    fontSize = 32.sp
                ),
            )

            if(i != codeLength - 1) {
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
    }
}