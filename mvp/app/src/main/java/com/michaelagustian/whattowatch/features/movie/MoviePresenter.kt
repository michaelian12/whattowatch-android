package com.michaelagustian.whattowatch.features.movie

import com.michaelagustian.whattowatch.model.Movie

/**
 * Created by Michael Agustian on 21/10/18.
 */

interface MoviePresenter {
    fun onResume()
    fun onDestroy()
    fun getMovieList(page: Int = 1)
    fun onSuccessGetMovieList(movies: List<Movie>?)
    fun onFailedGetMovieList(page: Int, message: String?)
}