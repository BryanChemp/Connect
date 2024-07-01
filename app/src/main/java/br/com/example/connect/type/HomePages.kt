package br.com.example.connect.type

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.example.connect.R

sealed class HomePages (
    val route: String,
    @DrawableRes val icon: Int
) {
    object Posts : HomePages(
        route = "posts",
        icon = R.drawable.ic_home
    )
    object Shorts : HomePages(
        route = "shorts",
        icon = R.drawable.ic_shorts
    )
    object Messages : HomePages(
        route = "messages",
        icon = R.drawable.ic_messages
    )
    object Settings : HomePages(
        route = "settings",
        icon = R.drawable.ic_settings
    )
    object Perfil : HomePages(
        route = "perfil",
        icon = R.drawable.ic_perfil
    )
}