package com.michaelagustian.whattowatch.features.movie

import com.michaelagustian.whattowatch.model.Movie

/**
 * Created by Michael Agustian on 21/10/18.
 */

interface MovieView {
    fun showLoading()
    fun hideLoading()
    fun showMessage(message: String?)
    fun setLayout(recyclerView: Boolean, emptyView: Boolean)
    fun showMovies(movies: List<Movie>?)
}