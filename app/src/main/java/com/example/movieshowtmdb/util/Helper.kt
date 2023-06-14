package com.example.movieshowtmdb.util

import com.example.movieshowtmdb.modules.home.models.GenresItem
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Locale

fun showMovieYear(date: String): String? {
    val parser = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    val formatter = SimpleDateFormat("yyyy", Locale.US)
    return parser.parse(date)?.let { formatter.format(it) }
}

fun showMovieDate(date: String): String? {
    val parser = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    val formatter = SimpleDateFormat("dd MMM yyyy", Locale.US)
    return parser.parse(date)?.let { formatter.format(it) }
}

fun roundFloorDecimal(number: Double): Double {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.FLOOR
    return df.format(number).toDouble()
}

fun listOfGenres(genres: List<GenresItem>): String {
    return if (genres.size == 1) {
        genres[0].name
    } else {
        val sb = StringBuilder()
        for (genre in genres) {
            sb.append("${genre.name}, ")
        }
        sb.toString().substring(0, sb.toString().length - 2)
    }
}