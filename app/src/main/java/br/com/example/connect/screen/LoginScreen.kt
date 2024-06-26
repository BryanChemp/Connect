package br.com.example.connect.screen

import android.content.Intent
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.activity.compose.BackHandler
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.example.connect.R
import br.com.example.connect.activity.RegisterActivity
import br.com.example.connect.components.PasswordTextField
import br.com.example.connect.components.SimpleTextField
import br.com.example.connect.components.VersionField
import br.com.example.connect.statics.DoubtList
import br.com.example.connect.ui.theme.ButtonTextStyle
import br.com.example.connect.ui.theme.MyTypography
import br.com.example.connect.ui.theme.Primary
import br.com.example.connect.ui.theme.PrimaryTransparent

@Composable
fun PreScreen(
    backDispatcher: OnBackPressedDispatcherOwner
){
    val context = LocalContext.current

    val offsetYButtons = remember { Animatable(0f) }
    val offsetYLogin = remember { Animatable(800f) }
    val offsetYDoubts = remember { Animatable(800f) }

    var showLogin by remember { mutableStateOf(false) }
    var showDoubts by remember { mutableStateOf(false) }

    LaunchedEffect(showLogin) {
        if (showLogin) {
            offsetYButtons.animateTo(
                targetValue = 800f,
                animationSpec = tween(
                    durationMillis = 350,
                    easing = Ease
                )
            )
            offsetYLogin.animateTo(
                targetValue = 0f,
                animationSpec = tween(
                    durationMillis = 350,
                    easing = Ease
                )
            )
        } else {
            offsetYLogin.animateTo(
                targetValue = 800f,
                animationSpec = tween(
                    durationMillis = 350,
                    easing = Ease
                )
            )
            offsetYButtons.animateTo(
                targetValue = 0f,
                animationSpec = tween(
                    durationMillis = 350,
                    easing = Ease
                )
            )
        }
    }

    LaunchedEffect(showDoubts) {
        if (showDoubts) {
            offsetYButtons.animateTo(
                targetValue = 800f,
                animationSpec = tween(
                    durationMillis = 350,
                    easing = Ease
                )
            )
            offsetYDoubts.animateTo(
                targetValue = 0f,
                animationSpec = tween(
                    durationMillis = 350,
                    easing = Ease
                )
            )
        } else {
            offsetYDoubts.animateTo(
                targetValue = 800f,
                animationSpec = tween(
                    durationMillis = 350,
                    easing = Ease
                )
            )
            offsetYButtons.animateTo(
                targetValue = 0f,
                animationSpec = tween(
                    durationMillis = 350,
                    easing = Ease
                )
            )
        }
    }

    BackHandler(showLogin || showDoubts) {
        if (showLogin) {
            showLogin = false
        } else if (showDoubts) {
            showDoubts = false
        } else {
            backDispatcher.onBackPressedDispatcher.onBackPressed()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.bg_login_screen),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )

        ContainerButtons (
            offsetY = offsetYButtons.value,
            onRegisterClicked = {
                if(!showDoubts && !showLogin){
                    val intent = Intent(context, RegisterActivity::class.java)
                    context.startActivity(intent)
                }
            },
            onLoginClicked = {
                showLogin = !showLogin
            },
            onDoubtsClicked = {
                showDoubts = !showDoubts
            }
        )

        ContainerLogin(
            offsetY = offsetYLogin.value,
            onHideLoginClicked = { showLogin = false},
        )

        ContainerDoubts(
            offsetY = offsetYDoubts.value
        ) { showDoubts = false }
    }
}



@Composable
fun ContainerButtons(
    offsetY: Float,
    onRegisterClicked: () -> Unit,
    onLoginClicked: () -> Unit,
    onDoubtsClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .offset(y = offsetY.dp),
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
                    color = Primary,
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
                    onClick = onRegisterClicked,
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
                        text = "Criar uma conta",
                        style = ButtonTextStyle.copy(
                            color = Primary
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onLoginClicked,
                    border = BorderStroke(
                        2.dp,
                        Color.White
                    ),
                    shape = RoundedCornerShape(
                        20.dp
                    ),
                    contentPadding = PaddingValues(
                        vertical = 12.dp
                    )
                ) {
                    Text(
                        text = "Já tenho uma conta",
                        style = ButtonTextStyle
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                TextButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onDoubtsClicked
                ) {
                    Text(
                        text = "Dúvidas frequentes",
                        style = MyTypography.labelMedium.copy(
                            color = Color.White,
                            textDecoration = TextDecoration.Underline,
                            textAlign = TextAlign.Center),
                        )
                }
            }
        }

        VersionField()
    }
}

@Composable
fun ContainerLogin(
    offsetY: Float,
    onHideLoginClicked: () -> Unit,
) {

    val emailValue = remember { mutableStateOf(TextFieldValue("")) }
    val passwordValue = remember { mutableStateOf(TextFieldValue("")) }
    val errorEmailMsg = remember { mutableStateOf("") }
    val errorPasswordMsg = remember { mutableStateOf("") }
    val validEmail = remember { mutableStateOf(false) }
    val validPassword = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .offset(y = offsetY.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom

    ) {

        Column (
            modifier = Modifier
                .fillMaxHeight(0.7f)
                .fillMaxWidth()
                .background(PrimaryTransparent),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){

            Column (
                Modifier
                    .fillMaxWidth(0.8f)
                    .padding()
            ) {

                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onHideLoginClicked) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "Botão voltar",
                            tint = Color.White,
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Acessar conta",
                        style = MyTypography.titleLarge.copy(
                            color = Color.White,
                            fontSize = 24.sp
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                SimpleTextField("Seu email", emailValue, errorEmailMsg)

                Spacer(modifier = Modifier.height(4.dp))

                PasswordTextField("Sua senha", passwordValue, errorPasswordMsg)

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        if(validateLogin(
                                emailValue,
                                passwordValue,
                                errorEmailMsg,
                                errorPasswordMsg,
                                validEmail,
                                validPassword)) {
                            // iniciar login
                        }
                    },
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
                        text = "Acessar",
                        style = ButtonTextStyle.copy(
                            color = Primary
                        )
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Esqueci minha senha",
                    style = MyTypography.labelMedium.copy(
                        color = Color.White,
                        textDecoration = TextDecoration.Underline,
                        textAlign = TextAlign.Center
                    )
                )

            }
        }

        VersionField()
    }
}

fun validateLogin(
    email: MutableState<TextFieldValue>,
    password: MutableState<TextFieldValue>,
    errorEmailMsg: MutableState<String>,
    errorPassMsg: MutableState<String>,
    validEmail: MutableState<Boolean>,
    validPassword: MutableState<Boolean>
) : Boolean {

    errorEmailMsg.value = " "
    errorPassMsg.value = " "

    validEmail.value = email.value.text == "bryan@gmail.com"
    validPassword.value = password.value.text == "1234"

    if(!validEmail.value) errorEmailMsg.value = "Email não cadastrado"
    if(!validPassword.value) errorPassMsg.value = "Senha incorreta"

    return  validEmail.value && validPassword.value
}

@Composable
fun ContainerDoubts(offsetY: Float, onHideDoubtsClicked: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .offset(y = offsetY.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {

        Column (
            modifier = Modifier
                .fillMaxHeight(0.7f)
                .fillMaxWidth()
                .background(PrimaryTransparent),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){

            Column (
                Modifier
                    .fillMaxWidth(0.8f)
                    .padding()
            ) {

                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onHideDoubtsClicked) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "Botão voltar",
                            tint = Color.White,
                        )
                    }
                    
                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Dúvidas frequentes",
                        style = MyTypography.titleLarge.copy(
                            color = Color.White,
                            fontSize = 24.sp
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                LazyColumn {
                    this.items(DoubtList.doubts) { doubt ->
                        ExpandableCard(title = doubt.title, description = doubt.description)
                        Spacer(modifier = Modifier.height(24.dp))
                    }
                }

            }
        }

        VersionField()
    }
}

@Composable
fun ExpandableCard(
    title: String,
    description: String,
) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f, label = ""
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
            .clickable {
                expandedState = !expandedState
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = title,
                    color = Color.White
                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }) {
                    Icon(
                        imageVector = Icons.Rounded.KeyboardArrowDown,
                        contentDescription = "Drop-Down Arrow",
                        tint = Color.White
                    )
                }
            }
            if (expandedState) {
                Text(
                    text = description,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 16.dp),
                )
            }
        }
    }
}