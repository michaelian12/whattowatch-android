package com.michaelagustian.whattowatch.di.component

import com.michaelagustian.whattowatch.di.module.NetworkModule
import com.michaelagustian.whattowatch.features.movie.MovieInteractorImpl
import com.michaelagustian.whattowatch.features.moviedetail.MovieDetailInteractorImpl
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Michael Agustian on 21/10/18.
 */

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(movieInteractor: MovieInteractorImpl)
    fun inject(movieDetailInteractor: MovieDetailInteractorImpl)
}