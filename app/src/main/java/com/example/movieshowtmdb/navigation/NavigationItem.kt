package com.example.kotlintesttmdb.navigation

sealed class NavigationItem (var route: String, var title: String){
    object Home : NavigationItem("home", "Home")
    object MoviesGenre : NavigationItem("moviesGenre/{withGenres}", "Movies Genre")
}