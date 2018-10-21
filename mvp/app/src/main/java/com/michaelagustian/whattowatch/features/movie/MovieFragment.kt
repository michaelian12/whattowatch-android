package com.michaelagustian.whattowatch.features.movie

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jcodecraeer.xrecyclerview.XRecyclerView
import com.michaelagustian.whattowatch.base.BaseFragment
import com.michaelagustian.whattowatch.Constant
import com.michaelagustian.whattowatch.R
import com.michaelagustian.whattowatch.model.Movie
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * Created by Michael Agustian on 21/10/18.
 */

class MovieFragment : BaseFragment(), MovieView {

    private lateinit var presenter: MoviePresenterImpl
    private val movieAdapter = MovieAdapter()
    private var page = 1

    companion object {
        fun newInstance(type: Int): MovieFragment {
            val bundle = Bundle()
            bundle.putInt(Constant.BUNDLE_TYPE, type)

            val fragment = MovieFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getResourceLayout() = R.layout.fragment_movie

    override fun onViewReady(savedInstanceState: Bundle?) {
        val type = arguments?.getInt(Constant.BUNDLE_TYPE) ?: throw IllegalStateException("Unknown tab type")
        presenter = MoviePresenterImpl(this, MovieInteractorImpl(), type)

        // Initialize Recycler View
        rv_movie_list.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            setPullRefreshEnabled(true)
            setLoadingMoreEnabled(true)
            setLoadingListener(object : XRecyclerView.LoadingListener {
                override fun onRefresh() {
                    presenter.getMovieList()
                }

                override fun onLoadMore() {
                    page++
                    presenter.getMovieList(page)
                }
            })
        }
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
        sfl_container.visibility = View.VISIBLE
        sfl_container.startShimmer()
    }

    override fun hideLoading() {
        sfl_container.stopShimmer()
        sfl_container.visibility = View.GONE

        rv_movie_list.apply {
            refreshComplete()
            loadMoreComplete()
        }
    }

    override fun setLayout(recyclerView: Boolean, emptyView: Boolean) {
        rv_movie_list?.visibility = if (recyclerView) View.VISIBLE else View.GONE
        rl_empty?.visibility = if (emptyView) View.VISIBLE else View.GONE
    }

    override fun showMovies(movies: List<Movie>?) {
        if (page == 1) {
            movieAdapter.movies.clear()
            movieAdapter.notifyDataSetChanged()
        }

        if (movies != null && movies.isNotEmpty()) {
            movieAdapter.movies.addAll(movies)
            setLayout(true, false)
        } else if (page == 1)
            setLayout(false, true)
    }
}