package com.example.kotlintesttmdb.pages

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.kotlintesttmdb.navigation.NavigationItem
import com.example.movieshowtmdb.modules.home.pages.Home
import com.example.movieshowtmdb.modules.movies_detail.pages.MoviesDetail
import com.example.movieshowtmdb.modules.movies_genre.pages.MoviesGenre
import com.example.movieshowtmdb.modules.movies_reviews.pages.MoviesReviews

@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Composable
fun NavigationPages(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            Home(navHostController = navHostController)
        }

        composable(
            NavigationItem.MoviesGenre.route,
            arguments = listOf(navArgument("withGenres") { type = NavType.StringType })
        ) {
            val withGenres = it.arguments?.getString("withGenres")
            MoviesGenre(withGenres = withGenres!!, navHostController = navHostController)
        }

        composable(
            NavigationItem.MoviesDetail.route,
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })
        ) {
            val movieId = it.arguments?.getString("movieId")?.toInt()
            MoviesDetail(movieId = movieId!!, navHostController = navHostController)
        }

        composable(
            NavigationItem.MoviesReviews.route,
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })
        ) {
            val movieId = it.arguments?.getString("movieId")?.toInt()
            MoviesReviews(movieId = movieId!!)
        }
    }
}