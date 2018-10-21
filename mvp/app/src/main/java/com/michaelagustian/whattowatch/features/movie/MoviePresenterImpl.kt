package com.michaelagustian.whattowatch.features.movie

import com.michaelagustian.whattowatch.model.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Michael Agustian on 21/10/18.
 */

class MoviePresenterImpl(
    private var view: MovieView?,
    private val interactor: MovieInteractor,
    private val type: Int
) : MoviePresenter {

    private var compositeDisposable = CompositeDisposable()

    override fun onResume() {
        view?.apply {
            setLayout(false, false)
            showLoading()
        }

        getMovieList()
    }

    override fun onDestroy() {
        view = null
        compositeDisposable.clear()
    }

    override fun getMovieList(page: Int) {
        compositeDisposable.add(
            interactor.getMovieList(type, page)
                .map {
                    it.results?.let { movies -> interactor.saveCache(movies) }
                    it
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ data ->
                    onSuccessGetMovieList(data.results)
                }, { throwable ->
                    try {
                        onFailedGetMovieList(page, throwable?.message)
                    } catch (e: Exception) {
                        onFailedGetMovieList(page, "An error occurred")
                    }
                })
        )
    }

    override fun onSuccessGetMovieList(movies: List<Movie>?) {
        view?.showMovies(movies)
        view?.hideLoading()
    }

    override fun onFailedGetMovieList(page: Int, message: String?) {
        if (page == 1) view?.setLayout(true, false)
        view?.apply {
            hideLoading()
            showMessage(message)
        }
    }
}