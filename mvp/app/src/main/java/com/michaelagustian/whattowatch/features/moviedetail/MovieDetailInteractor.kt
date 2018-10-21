package com.michaelagustian.whattowatch.features.moviedetail

import com.michaelagustian.whattowatch.model.Movie
import io.reactivex.Flowable

/**
 * Created by Michael Agustian on 21/10/18.
 */

interface MovieDetailInteractor {
    fun getMovieDetail(movieId: Int): Flowable<Movie>
    fun saveCache(movie: Movie?)
    fun getCache(movieId: Int): Movie?
}