package com.michaelagustian.whattowatch.data

import com.michaelagustian.whattowatch.model.Movie
import com.michaelagustian.whattowatch.model.ResultList
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Michael Agustian on 21/10/18.
 */

interface ApiService {

    @GET("discover/movie/")
    fun getMovieDiscover(
        @Query("page") page: Int
    ): Flowable<ResultList<Movie>>

    @GET("movie/top_rated")
    fun getMovieTopRated(
        @Query("page") page: Int
    ): Flowable<ResultList<Movie>>

    @GET("movie/popular")
    fun getMoviePopular(
        @Query("page") page: Int
    ): Flowable<ResultList<Movie>>

    @GET("movie/now_playing")
    fun getMovieNowPlaying(
        @Query("page") page: Int
    ): Flowable<ResultList<Movie>>

    @GET("movie/upcoming")
    fun getMovieUpcoming(
        @Query("page") page: Int
    ): Flowable<ResultList<Movie>>

    @GET("movie/{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") movieId: Int
    ): Flowable<Movie>
}