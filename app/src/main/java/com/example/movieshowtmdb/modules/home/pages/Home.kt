package com.example.movieshowtmdb.modules.home.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.movieshowtmdb.composable.CircularLoading
import com.example.movieshowtmdb.modules.home.viewmodel.HomeViewModel
import com.example.movieshowtmdb.ui.theme.Purple40
import com.example.movieshowtmdb.ui.theme.Purple80
import org.koin.androidx.compose.getViewModel

@ExperimentalMaterial3Api
@Composable
fun Home(viewModel: HomeViewModel = getViewModel(), navHostController: NavHostController) {
    val genresState = viewModel.state.value
    val genreList = genresState.data?.genres

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Genre") })
    }) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (genresState.isLoading) {
                CircularLoading()
            } else if (genreList != null && !genresState.isLoading) {
                Column {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2)
                    ) {
                        items(genreList) { item ->
                            Card(colors = CardDefaults.cardColors(
                                containerColor = Purple80,
                            ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                                    .height(90.dp)
                                    .clickable {
                                        navHostController.navigate("moviesGenre/${item.id}")
                                    }) {
                                Text(
                                    text = item.name,
                                    fontSize = 20.sp,
                                    modifier = Modifier.padding(all = 8.dp),
                                    color = Purple40
                                )
                            }
                        }
                    }
                }
            } else {
                Snackbar {
                    Text(text = "Error Fetching Data")
                }
            }
        }
    }
}