package com.michaelagustian.whattowatch.features.movie

import com.michaelagustian.whattowatch.model.Movie
import com.michaelagustian.whattowatch.model.ResultList
import io.reactivex.Flowable

/**
 * Created by Michael Agustian on 21/10/18.
 */

interface MovieInteractor {
    fun getMovieList(type: Int, page: Int): Flowable<ResultList<Movie>>
    fun saveCache(movies: List<Movie>?)
}