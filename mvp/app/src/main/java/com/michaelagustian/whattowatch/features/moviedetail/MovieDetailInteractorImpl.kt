package com.michaelagustian.whattowatch.features.moviedetail

import com.michaelagustian.whattowatch.BaseApplication
import com.michaelagustian.whattowatch.data.ApiService
import com.michaelagustian.whattowatch.model.Movie
import io.reactivex.Flowable
import io.realm.Realm
import javax.inject.Inject

/**
 * Created by Michael Agustian on 21/10/18.
 */

class MovieDetailInteractorImpl : MovieDetailInteractor {

    @Inject
    lateinit var apiService: ApiService

    init {
        BaseApplication.applicationComponent.inject(this)
    }

    override fun getMovieDetail(movieId: Int): Flowable<Movie> {
        return apiService.getMovieDetail(movieId)
    }

    override fun saveCache(movie: Movie?) {
        movie?.let {
            val realm = Realm.getDefaultInstance()

            if (!realm.isInTransaction)
                realm.beginTransaction()

            realm.copyToRealmOrUpdate(movie)
            realm.commitTransaction()
        }
    }

    override fun getCache(movieId: Int): Movie? {
        val realm = Realm.getDefaultInstance()
        return realm.where(Movie::class.java).equalTo("id", movieId).findFirst()
    }
}