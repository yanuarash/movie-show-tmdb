package com.example.movieshowtmdb.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CircularLoading(){
    CircularProgressIndicator(
        modifier = Modifier
            .size(size = 40.dp)
            .padding(all = 8.dp),
        color = Color.Magenta,
        strokeWidth = 6.dp
    )
}