package com.michaelagustian.whattowatch.features.moviedetail

import com.michaelagustian.whattowatch.model.Movie

/**
 * Created by Michael Agustian on 21/10/18.
 */

interface MovieDetailPresenter {
    fun onResume()
    fun onDestroy()
    fun getMovieDetail(movieId: Int)
    fun getCache(movieId: Int)
    fun onSuccessGetMovieDetail(movie: Movie?)
    fun onFailedGetMovieDetail(message: String?)
}