package br.com.example.connect.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.example.connect.components.PasswordTextFieldWithoutLabel
import br.com.example.connect.components.PasswordTextFieldWithoutLabelAndButton
import br.com.example.connect.components.SimpleCheckbox
import br.com.example.connect.ui.theme.ButtonTextStyle
import br.com.example.connect.ui.theme.MyTypography
import br.com.example.connect.ui.theme.Primary
import br.com.example.connect.ui.theme.PrimaryTransparent
import br.com.example.connect.ui.theme.PrimaryTransparent2

@Composable
fun RegisterFinalPage() {
    val checkTermsValue = remember { mutableStateOf((false)) }
    val errorCheckTerms = remember { mutableStateOf("") }
    val checkNewsValue = remember { mutableStateOf((false)) }

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
                        text = "Agora é só finalizar\no cadastro",
                        style = MyTypography.titleLarge.copy(
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center,
                            color = Color.White
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Column {

                    SimpleCheckbox(
                        text = "Declaro que li e concordo com os termos e políticas de privacidade",
                        isChecked = checkTermsValue
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    SimpleCheckbox(
                        text = "Aceito receber novidades no meu email",
                        isChecked = checkNewsValue
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {},
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
                            text = "Finalizar",
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