package com.michaelagustian.whattowatch.features.moviedetail

import com.michaelagustian.whattowatch.model.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Michael Agustian on 21/10/18.
 */

class MovieDetailPresenterImpl(
    var view: MovieDetailView?,
    private val interactor: MovieDetailInteractor,
    private val movieId: Int
) : MovieDetailPresenter {

    private var compositeDisposable = CompositeDisposable()

    override fun onResume() {
        view?.apply {
            setLayout(false)
            showLoading()
        }

        getMovieDetail(movieId)
    }

    override fun onDestroy() {
        view = null
        compositeDisposable.clear()
    }

    override fun getMovieDetail(movieId: Int) {
        getCache(movieId)
        compositeDisposable.add(
            interactor.getMovieDetail(movieId)
                .map {
                    interactor.saveCache(it)
                    it
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ data ->
                    onSuccessGetMovieDetail(data)
                }, { throwable ->
                    try {
                        onFailedGetMovieDetail(throwable?.message)
                    } catch (e: Exception) {
                        onFailedGetMovieDetail("An error occurred")
                    }
                })
        )
    }

    override fun getCache(movieId: Int) {
        interactor.getCache(movieId)?.let {
            onSuccessGetMovieDetail(it)
        }
    }

    override fun onSuccessGetMovieDetail(movie: Movie?) {
        view?.setLayout(true, movie)
    }

    override fun onFailedGetMovieDetail(message: String?) {
        view?.apply {
            hideLoading()
            showMessage(message)
        }
    }
}