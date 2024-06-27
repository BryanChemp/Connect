package br.com.example.connect.page.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.example.connect.components.CodeTextField
import br.com.example.connect.ui.theme.ButtonTextStyle
import br.com.example.connect.ui.theme.MyTypography
import br.com.example.connect.ui.theme.Primary
import br.com.example.connect.ui.theme.PrimaryTransparent2
import br.com.example.connect.ui.theme.TextFieldLabelStyle

@Composable
fun RegisterCodePage(goToNextStep: () -> Unit) {
    val codeLength = 5
    val codeValues = List(codeLength) { remember { mutableStateOf(TextFieldValue("")) } }
    val errorCodeMsg = remember { mutableStateOf("") }

    Column (
        Modifier
            .background(PrimaryTransparent2)
            .fillMaxWidth()
            .fillMaxHeight(0.9f),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column (
            Modifier
                .fillMaxWidth(0.8f)
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Spacer(modifier = Modifier.fillMaxHeight(0.1f))

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Confirme seu email",
                        style = MyTypography.titleLarge.copy(
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center,
                            color = Color.White
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Digite o código que chegou\nno seu email",
                        style = TextFieldLabelStyle.copy(
                            textAlign = TextAlign.Center,
                            color = Color.White
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Column {

                    CodeTextField(codeValues, codeLength)

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Reenviar",
                        style = MyTypography.labelMedium.copy(
                            color = Color.White,
                            textDecoration = TextDecoration.Underline,
                            textAlign = TextAlign.Start
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = goToNextStep,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        ),
                        shape = RoundedCornerShape(
                            20.dp
                        ),
                        contentPadding = PaddingValues(
                            vertical = 12.dp
                        )
                    ) {
                        Text(
                            text = "Continuar",
                            style = ButtonTextStyle.copy(
                                color = Primary
                            )
                        )
                    }
                }
            }
        }
    }
}