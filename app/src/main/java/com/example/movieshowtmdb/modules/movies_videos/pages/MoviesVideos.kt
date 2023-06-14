package com.example.movieshowtmdb.modules.movies_videos.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieshowtmdb.modules.movies_videos.viewmodel.MoviesVideosViewModel
import com.example.movieshowtmdb.util.Constants
import org.koin.androidx.compose.getViewModel

@ExperimentalMaterial3Api
@Composable
fun MoviesVideos(
    viewModel: MoviesVideosViewModel = getViewModel(),
    movieId: Int,
) {
    val reviewsState = viewModel.state.value
    val reviewsList = reviewsState.data?.results
    val uriHandler = LocalUriHandler.current

    LaunchedEffect(key1 = movieId) {
        viewModel.getMoviesVideos(movieId)
    }

    Column {
        if (reviewsList != null) {
            LazyRow(contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)) {
                items(reviewsList) { item ->
                    if (item.site.lowercase().equals("youtube")) {
                        Card(
                            modifier = Modifier
                                .width(250.dp)
                                .height(100.dp)
                                .clickable { uriHandler.openUri(Constants.YOUTUBE_URL + item.key) }
                                .padding(8.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.DarkGray,
                            )
                        ) {
                            Box {
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(Constants.YOUTUBE_THUMBNAIL + item.key + Constants.YOUTUBE_THUMBNAIL_RES)
                                        .crossfade(true)
                                        .build(),
                                    contentDescription = "Trailer Image",
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    contentScale = ContentScale.Crop,
                                )
                            }
                        }
                    }
                }
            }
        } else {

        }
    }
}