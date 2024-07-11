package br.com.example.connect.screen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.example.connect.components.HomeBottomNav
import br.com.example.connect.components.HomeTopBar
import br.com.example.connect.components.MessagesActionBtn
import br.com.example.connect.page.home.MessagesPage
import br.com.example.connect.page.home.PerfilPage
import br.com.example.connect.page.home.PostsPage
import br.com.example.connect.page.home.SettingsPage
import br.com.example.connect.page.home.ShortsPage
import br.com.example.connect.page.register.RegisterCodePage
import br.com.example.connect.page.register.RegisterEmailPage
import br.com.example.connect.page.register.RegisterFinalPage
import br.com.example.connect.page.register.RegisterNamePage
import br.com.example.connect.page.register.RegisterPasswordPage

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    val pagerState = rememberPagerState(initialPage = 0)

    Scaffold (
        topBar = {
            HomeTopBar(pageIndex = pagerState.currentPage)
        },
        bottomBar = { HomeBottomNav(pagerState = pagerState) },
        floatingActionButton = { FloatingActionBtn(pagerState = pagerState) }
    ){
        Box(
            Modifier
                .fillMaxSize()

        ) {
            HorizontalPager(
                modifier = Modifier.fillMaxSize(),
                state = pagerState,
                pageCount = 5,
            ) { page ->
                when (page) {

                    0 -> PostsPage()
                    1 -> ShortsPage()
                    2 -> MessagesPage()
                    3 -> SettingsPage()
                    4 -> PerfilPage()

                }
            }
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FloatingActionBtn(
    pagerState: PagerState
) {
    when(pagerState.currentPage) {

        0 -> {}
        1 -> {}
        2 -> MessagesActionBtn()
        3 -> {}
        4 -> {}

    }
}