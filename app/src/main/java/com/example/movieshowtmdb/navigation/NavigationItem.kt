package com.example.movieshowtmdb.navigation

sealed class NavigationItem(var route: String, var title: String) {
    object Home : NavigationItem("home", "Home")
    object MoviesGenre : NavigationItem("moviesGenre/{withGenres}/{nameGenre}", "Movies Genre")
    object MoviesDetail : NavigationItem("moviesDetail/{movieId}", "Movies Detail")
    object MoviesReviews : NavigationItem("moviesReviews/{movieId}", "Movies Reviews")
}