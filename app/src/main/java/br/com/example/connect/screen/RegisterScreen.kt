import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.example.connect.R
import br.com.example.connect.components.VersionField
import br.com.example.connect.page.RegisterCodePage
import br.com.example.connect.page.RegisterEmailPage
import br.com.example.connect.page.RegisterFinalPage
import br.com.example.connect.page.RegisterNamePage
import br.com.example.connect.page.RegisterPasswordPage
import br.com.example.connect.ui.theme.Primary
import br.com.example.connect.ui.theme.PrimaryTransparent
import br.com.example.connect.ui.theme.PrimaryTransparent2

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class,
    ExperimentalComposeUiApi::class
)
@Composable
fun RegisterScreen() {

    val pagerState = rememberPagerState(initialPage = 0)

    val isFocused by keyboardAsState()

    Scaffold (
        bottomBar = {
            VersionField()
        }
    ){

        Box(
            Modifier.fillMaxSize()
        ) {

            Image(
                painter = painterResource(id = R.drawable.bg_register_screen),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )

            Column (
                Modifier
                    .fillMaxSize()
                    .background(PrimaryTransparent2)
            ) {

                TopBar(isFocused = isFocused)

                HorizontalPager(
                    modifier = Modifier.fillMaxSize(),
                    state = pagerState,
                    pageCount = 5
                ) { page ->
                    when (page) {

                        0 -> RegisterEmailPage()
                        1 -> RegisterNamePage()
                        2 -> RegisterCodePage()
                        3 -> RegisterPasswordPage()
                        4 -> RegisterFinalPage()

                    }
                }

            }
        }


    }
}

@Composable
fun TopBar(isFocused: Boolean){
    val heightFraction by animateFloatAsState(targetValue = if (isFocused) 0f else 0.2f, label = "")

    Row (
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(heightFraction)
            .background(PrimaryTransparent2),
        verticalAlignment = Alignment.Bottom
    ) {
        
        Spacer(modifier = Modifier.width(24.dp))
        
        IconButton(
            modifier = Modifier
                .size(44.dp),
            onClick = {  }
        ) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = "Back button",
                tint = Color.White
            )
        }
    }
}

@Composable
fun keyboardAsState(): State<Boolean> {
    val isImeVisible = WindowInsets.ime.getBottom(LocalDensity.current) > 0
    return rememberUpdatedState(isImeVisible)
}
