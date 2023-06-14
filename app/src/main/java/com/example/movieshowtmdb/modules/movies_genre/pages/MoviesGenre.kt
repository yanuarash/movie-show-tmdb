package com.example.movieshowtmdb.modules.movies_genre.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieshowtmdb.modules.movies_genre.viewmodel.MoviesGenreViewModel
import com.example.movieshowtmdb.util.Constants
import org.koin.androidx.compose.getViewModel

@ExperimentalMaterial3Api
@Composable
fun MoviesGenre(
    viewModel: MoviesGenreViewModel = getViewModel(),
    withGenres: String,
    navHostController: NavHostController,
) {
    var page by rememberSaveable { mutableStateOf(0) }

    LaunchedEffect(key1 = withGenres) {
        if (page == 0) {
            page += 1
            viewModel.getMoviesGenre(page, withGenres)
        }
    }
    val movieGenreState = viewModel.state.value
    val movieGenreList = viewModel.list

    val lazyColumnState = rememberLazyListState()
    val isBottom by remember {
        derivedStateOf {
            lazyColumnState.isScrolledToEnd()
        }
    }
    LaunchedEffect(isBottom) {
        if (isBottom && !movieGenreState.isLoading) {
            page += 1
            viewModel.getMoviesGenre(page, withGenres)
        }
    }

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Movies Genre") })
    }) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            if (movieGenreList.size > 0) {
                Column {
                    LazyColumn(
                        modifier = Modifier.weight(1F),
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp),
                        state = lazyColumnState
                    ) {
                        items(movieGenreList) { item ->
                            Card(modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .clickable {
                                    navHostController.navigate("moviesDetail/${item.id}")
                                }) {
                                Box(
                                    modifier = Modifier
                                        .height(200.dp)
                                        .fillMaxWidth()
                                ) {
                                    AsyncImage(
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data(Constants.IMAGE_W1280_URL + item.backdrop_path)
                                            .crossfade(true).build(),
                                        contentDescription = "Movie Image",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop,
                                    )
                                    Column {
                                        Modifier
                                            .fillMaxSize()
                                            .background(
                                                Brush.verticalGradient(
                                                    listOf(
                                                        Color.Transparent, Color.Black
                                                    ), 0f, 500f
                                                )
                                            )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .background(
                                                brush = Brush.verticalGradient(
                                                    colors = listOf(
                                                        Color.Transparent,
                                                        Color.Black,
                                                    ), 0f, 1000f
                                                )
                                            )
                                            .fillMaxSize()
                                    ) {
                                        Text(
                                            text = item.title,
                                            modifier = Modifier
                                                .align(Alignment.BottomStart)
                                                .padding(all = 8.dp), color = Color.White
                                        )
                                    }
                                }
                            }
                        }
                    }
                    if (movieGenreState.isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(size = 40.dp)
                                .padding(all = 8.dp),
                            color = Color.Magenta,
                            strokeWidth = 6.dp
                        )
                    }
                }
            } else if (movieGenreState.error.isNotEmpty()) {
                Snackbar {
                    Text(text = movieGenreState.error)
                }
            } else {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(size = 40.dp)
                        .padding(all = 8.dp),
                    color = Color.Magenta,
                    strokeWidth = 6.dp
                )
            }
        }
    }
}

fun LazyListState.isScrolledToEnd() =
    layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1

