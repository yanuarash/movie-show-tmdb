package com.example.movieshowtmdb.modules.movies_detail.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.movieshowtmdb.composable.CircularLoading
import com.example.movieshowtmdb.modules.movies_detail.viewmodel.MoviesDetailViewModel
import com.example.movieshowtmdb.modules.movies_videos.pages.MoviesVideos
import com.example.movieshowtmdb.util.Constants
import com.example.movieshowtmdb.util.listOfGenres
import com.example.movieshowtmdb.util.roundFloorDecimal
import com.example.movieshowtmdb.util.showMovieDate
import com.example.movieshowtmdb.util.showMovieYear
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
            if (moviesState.isLoading) {
                CircularLoading()
            } else if (moviesDetail != null) {
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
                            .align(Alignment.CenterHorizontally),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row() {
                            Text(
                                text = "${moviesDetail.title}(${showMovieYear(moviesDetail.release_date)})",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                        if (moviesDetail.tagline.isNotEmpty()) {
                            Text(
                                text = moviesDetail.tagline,
                                color = Color.LightGray,
                                textAlign = TextAlign.Center
                            )
                        }
                        Text(
                            text = "✪ ${roundFloorDecimal(moviesDetail.vote_average.toDouble())}",
                            color = Color.DarkGray,
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
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp)
                    )
                    MoviesVideos(movieId = movieId)
                    Divider(
                        color = Color.DarkGray, modifier = Modifier
                            .fillMaxWidth()
                            .width(1.dp)
                    )
                    Column(modifier = Modifier.padding(all = 8.dp)) {
                        Row() {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            ) {
                                Text(
                                    text = "Genres", fontWeight = FontWeight.Bold, fontSize = 16.sp
                                )
                                Text(text = listOfGenres(moviesDetail.genres), fontSize = 14.sp)
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            ) {
                                Text(
                                    text = "Release Date",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                                showMovieDate(moviesDetail.release_date)?.let {
                                    Text(
                                        text = it, fontSize = 14.sp
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Overview", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        Text(text = moviesDetail.overview, fontSize = 14.sp)
                    }
                }
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 8.dp),
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


