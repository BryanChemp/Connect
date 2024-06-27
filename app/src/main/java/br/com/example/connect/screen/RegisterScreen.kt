import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
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
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.example.connect.R
import br.com.example.connect.components.VersionField
import br.com.example.connect.page.register.RegisterCodePage
import br.com.example.connect.page.register.RegisterEmailPage
import br.com.example.connect.page.register.RegisterFinalPage
import br.com.example.connect.page.register.RegisterNamePage
import br.com.example.connect.page.register.RegisterPasswordPage
import br.com.example.connect.ui.theme.PrimaryTransparent2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class,
    ExperimentalComposeUiApi::class
)
@Composable
fun RegisterScreen() {

    val context = LocalContext.current

    val pagerState = rememberPagerState(initialPage = 0)
    val coroutineScope = rememberCoroutineScope()

    val isFocused by keyboardAsState()

    BackHandler(pagerState.currentPage > 0) {
        backStep(coroutineScope, pagerState, context)
    }


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

                TopBar(
                    isFocused = isFocused
                ) {
                    if(pagerState.currentPage > 0){
                        backStep(coroutineScope, pagerState, context)
                    } else {
                        (context as? Activity)?.finish()
                    }
                }

                HorizontalPager(
                    modifier = Modifier.fillMaxSize(),
                    state = pagerState,
                    pageCount = 5,
                    userScrollEnabled = false
                ) { page ->
                    when (page) {

                        0 -> RegisterEmailPage() { goToNextStep(coroutineScope, pagerState, context) }
                        1 -> RegisterNamePage() { goToNextStep(coroutineScope, pagerState, context) }
                        2 -> RegisterCodePage() { goToNextStep(coroutineScope, pagerState, context) }
                        3 -> RegisterPasswordPage() { goToNextStep(coroutineScope, pagerState, context) }
                        4 -> RegisterFinalPage() { goToNextStep(coroutineScope, pagerState, context) }

                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
fun goToNextStep(coroutineScope: CoroutineScope, pagerState: PagerState,  context: Context) {
    coroutineScope.launch {
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val currentFocus = (context as? Activity)?.currentFocus
        currentFocus?.let {
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
        pagerState.animateScrollToPage(pagerState.currentPage + 1)
    }
}

@OptIn(ExperimentalFoundationApi::class)
fun backStep(coroutineScope: CoroutineScope, pagerState: PagerState, context: Context) {
    coroutineScope.launch {
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val currentFocus = (context as? Activity)?.currentFocus
        currentFocus?.let {
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
        pagerState.animateScrollToPage(pagerState.currentPage - 1)
    }
}

@Composable
fun TopBar(
    isFocused: Boolean,
    onBackClicked: () -> Unit
){
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
            onClick = onBackClicked
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
