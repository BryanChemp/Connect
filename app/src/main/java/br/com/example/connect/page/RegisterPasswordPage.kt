package br.com.example.connect.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RegisterPasswordPage() {
    Column (
        Modifier.fillMaxSize()
    ) {
        Text(text = "Crie uma senha")
    }
}