package com.example.kotlintesttmdb.navigation

sealed class NavigationItem (var route: String, var title: String){
    object Home : NavigationItem("home", "Home");
}