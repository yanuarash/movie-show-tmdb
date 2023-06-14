package com.example.movieshowtmdb

import android.app.Application
import com.example.kotlintesttmdb.di.networkModule
import com.example.kotlintesttmdb.di.repoModule
import com.example.kotlintesttmdb.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AppMovie : Application() {

    override fun onCreate() {
        super.onCreate()

        val modules = listOf(networkModule, viewModelModule, repoModule)

        startKoin {
            androidLogger(level = Level.NONE)
            androidContext(this@AppMovie)
            modules(modules)
        }
    }
}