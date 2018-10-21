package com.michaelagustian.whattowatch.features.moviedetail

import com.michaelagustian.whattowatch.model.Movie

/**
 * Created by Michael Agustian on 21/10/18.
 */

interface MovieDetailView {
    fun showLoading()
    fun hideLoading()
    fun showMessage(message: String?)
    fun setLayout(detailView: Boolean, movie: Movie? = null)
}