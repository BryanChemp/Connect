package br.com.example.connect.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.example.connect.type.HomePages
import br.com.example.connect.ui.theme.Gray
import br.com.example.connect.ui.theme.Primary
import br.com.example.connect.ui.theme.PrimaryTransparent
import br.com.example.connect.ui.theme.PrimaryTransparent2
import br.com.example.connect.ui.theme.PrimaryTransparent3
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeBottomNav(
    pagerState: PagerState
) {
    val screens = listOf(
        HomePages.Posts,
        HomePages.Shorts,
        HomePages.Messages,
        HomePages.Settings,
        HomePages.Perfil
    )

    val coroutineScope = rememberCoroutineScope()

    Column (
        modifier = Modifier.fillMaxWidth()
    ) {

        Spacer(modifier = Modifier.fillMaxWidth().height(0.5.dp).background(Color.LightGray))

        NavigationBar(
            containerColor = PrimaryTransparent3,
        ) {
            Spacer(modifier = Modifier.width(8.dp))

            screens.forEachIndexed { index, screen ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            modifier = Modifier.size(28.dp),
                            painter = painterResource(id = screen.icon),
                            contentDescription = screen.route)
                    },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = Gray
                    )
                )
            }

            Spacer(modifier = Modifier.width(8.dp))
        }
    }


}