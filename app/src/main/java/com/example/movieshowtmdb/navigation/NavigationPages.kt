package com.example.kotlintesttmdb.pages

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlintesttmdb.navigation.NavigationItem
import com.example.movieshowtmdb.modules.home.pages.Home

@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Composable
fun NavigationPages(navHostController: NavHostController){
    NavHost(navController = navHostController,  startDestination = NavigationItem.Home.route){
        composable(NavigationItem.Home.route){
            Home(navHostController = navHostController)
        }
    }
}