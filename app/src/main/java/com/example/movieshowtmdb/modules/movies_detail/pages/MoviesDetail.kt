package com.example.movieshowtmdb.modules.movies_detail.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.kotlintesttmdb.pages.movies_detail.MoviesDetailViewModel
import com.example.movieshowtmdb.modules.movies_videos.pages.MoviesVideos
import com.example.movieshowtmdb.util.Constants
import org.koin.androidx.compose.getViewModel

@ExperimentalMaterial3Api
@Composable
fun MoviesDetail(
    viewModel: MoviesDetailViewModel = getViewModel(),
    movieId: Int,
    navHostController: NavHostController
) {
    val moviesState = viewModel.state.value
    val moviesDetail = moviesState.data

    LaunchedEffect(key1 = movieId) {
        viewModel.getMoviesDetail(movieId)
    }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            if (moviesDetail != null) {
                Column {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(Constants.IMAGE_W1280_URL + moviesDetail.backdrop_path)
                            .crossfade(true).build(),
                        contentDescription = "Movie Image",
                        modifier = Modifier
                            .height(300.dp)
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop,
                    )
                    Column(
                        modifier = Modifier
                            .padding(all = 10.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = moviesDetail.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                        if (!moviesDetail.tagline.isEmpty()) {
                            Text(
                                text = moviesDetail.tagline,
                                color = Color.LightGray,
                                textAlign = TextAlign.Center
                            )
                        }
                        Text(
                            text = "✪${moviesDetail.vote_average}",
                            color = Color.LightGray,
                            textAlign = TextAlign.Center
                        )
                    }
                    Divider(
                        color = Color.DarkGray, modifier = Modifier
                            .fillMaxWidth()
                            .width(1.dp)
                    )
                    Text(
                        text = "Youtube Videos",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp)
                    )
                    MoviesVideos(movieId = movieId)
                    Divider(
                        color = Color.DarkGray, modifier = Modifier
                            .fillMaxWidth()
                            .width(1.dp)
                    )
                    Column(modifier = Modifier.padding(all = 8.dp)) {
                        Text(text = "Overview", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        Text(text = moviesDetail.overview)
                    }
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 12.dp),
                    onClick = { navHostController.navigate("moviesReviews/${moviesDetail.id}") }) {
                    Text(text = "User Reviews(${moviesDetail.vote_average})")
                }
            } else {
                Snackbar {
                    Text(text = "Error Fetching Data")
                }
            }
        }
    }
}


