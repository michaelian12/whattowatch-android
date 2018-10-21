package com.michaelagustian.whattowatch.features.moviedetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.michaelagustian.whattowatch.R
import com.michaelagustian.whattowatch.base.BaseActivity
import com.michaelagustian.whattowatch.Constant
import com.michaelagustian.whattowatch.model.Movie
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.item_movie_poster.*

/**
 * Created by Michael Agustian on 21/10/18.
 */

class MovieDetailActivity : BaseActivity(), MovieDetailView {

    private lateinit var presenter: MovieDetailPresenterImpl

    companion object {
        fun getStartIntent(context: Context, movieId: Int): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(Constant.INTENT_MOVIE_ID, movieId)
            return intent
        }
    }

    override fun getResourceLayout() = R.layout.activity_movie_detail

    override fun onViewReady(savedInstanceState: Bundle?) {
        setupToolbar(view_toolbar, true)

        val movieId = intent.getIntExtra(Constant.INTENT_MOVIE_ID, 0)
        presenter = MovieDetailPresenterImpl(this, MovieDetailInteractorImpl(), movieId)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showLoading() {
        progress_bar.visibility = View.VISIBLE
        sfl_movie_detail.visibility = View.VISIBLE
        sfl_movie_detail.startShimmer()
    }

    override fun hideLoading() {
        progress_bar.visibility = View.GONE
        sfl_movie_detail.visibility = View.GONE
        sfl_movie_detail.stopShimmer()
    }

    override fun setLayout(detailView: Boolean, movie: Movie?) {
        if (detailView) {
            lin_movie_detail?.visibility = View.VISIBLE

            movie?.let {
                img_movie_backdrop.setImageURI(movie.getBackdrop())
                img_movie_poster.setImageURI(movie.getPoster())
                tv_movie_title.text = movie.title
                tv_movie_rating.text = movie.voteAverage.toString()
                tv_movie_overview.text = movie.overview
            }

            hideLoading()
        } else
            lin_movie_detail?.visibility = View.GONE
    }
}