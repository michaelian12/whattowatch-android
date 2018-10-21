package com.michaelagustian.whattowatch.features.movie

import com.michaelagustian.whattowatch.BaseApplication
import com.michaelagustian.whattowatch.Constant
import com.michaelagustian.whattowatch.data.ApiService
import com.michaelagustian.whattowatch.model.Movie
import com.michaelagustian.whattowatch.model.ResultList
import io.reactivex.Flowable
import io.realm.Realm
import javax.inject.Inject

/**
 * Created by Michael Agustian on 21/10/18.
 */

class MovieInteractorImpl : MovieInteractor {

    @Inject
    lateinit var apiService: ApiService

    init {
        BaseApplication.applicationComponent.inject(this)
    }

    override fun getMovieList(type: Int, page: Int): Flowable<ResultList<Movie>> {
        return when (type) {
            Constant.TAB_MOVIE_DISCOVER -> apiService.getMovieDiscover(page)
            Constant.TAB_MOVIE_TOP_RATED -> apiService.getMovieTopRated(page)
            Constant.TAB_MOVIE_POPULAR -> apiService.getMoviePopular(page)
            Constant.TAB_MOVIE_NOW_PLAYING -> apiService.getMovieNowPlaying(page)
            Constant.TAB_MOVIE_UPCOMING -> apiService.getMovieUpcoming(page)
            else -> throw IllegalStateException("Unknown tab type")
        }
    }

    override fun saveCache(movies: List<Movie>?) {
        if (movies != null && movies.isNotEmpty()) {
            val realm = Realm.getDefaultInstance()

            if (!realm.isInTransaction)
                realm.beginTransaction()

            realm.copyToRealmOrUpdate(movies)
            realm.commitTransaction()
        }
    }
}